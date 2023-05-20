package charming.actualCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable {

    private ArrayList<ConnectionHandler> connections;
    private ServerSocket server;
    private int portNumber;
    private ExecutorService threadPool;

    private boolean serverRunning;

    public Server(int port){
        this.connections = new ArrayList<>();
        this.portNumber = port;
        this.threadPool = Executors.newCachedThreadPool();

    }
    
    public void broadcastMessage(String message){
        connections.forEach(conn ->{
            
            if(conn == null) return;

            conn.sendMessage(message);
        });
    }

    public void serverLoop(){
        try{
            do{
            Socket client = server.accept();

            ConnectionHandler handler = new ConnectionHandler(client);
            connections.add(handler);
            threadPool.execute(handler);
            

            }while(serverRunning);
    
        }catch(IOException e){
            // TODO: handle
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        startup();
    }

    public void shutdown(){
        try{
            
            if(!serverRunning) return;

            server.close();

            connections.forEach(conn ->{
                conn.clientShutdown();
            });
            
        }catch(IOException e){
            //TODO
        }
    }

    public void startup(){
        this.serverRunning = true;
        try{
            server = new ServerSocket(this.portNumber);
        }
        catch(IOException e){
            this.serverRunning = true;
        }
        System.out.println("Server running and listening on port:"+this.portNumber);
        serverLoop();
    }

    class ConnectionHandler implements Runnable {


        private Socket client;
        private BufferedReader input;
        private PrintWriter output;
        private String nick;

        public ConnectionHandler(Socket client){
            this.client = client;
        }


        public void sendMessage(String message){
            output.println(message);
        }

        


        @Override
        public void run(){
            try{
                output = new PrintWriter(client.getOutputStream(), true);
                input = new BufferedReader(new InputStreamReader(client.getInputStream()));
                output.println("Enter a nick:");
                nick = input.readLine();

                System.out.println("Client connected.");
                broadcastMessage(nick + "has joined the chat.");
                
                String message;

                while((message = input.readLine()) != null){
                    broadcastMessage(nick+": "+message);
                }
                
            }catch(IOException e){
                //TODO:Handle
                e.printStackTrace(output);
            }
        }
    
        public void clientShutdown(){
            try {
                output.println("Client shutting down.");
                System.out.println("Client :"+nick+" shutdown.  ");
                input.close();
                output.close();
                client.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
    
}
