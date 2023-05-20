package charming.actualCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable{
   
   private String ipString;
   private int portNumber;
   private Socket client;
   private BufferedReader input;
   private PrintWriter output; 
   
   public Client(String ipString,int portNumber){
    this.ipString = ipString;
    this.portNumber = portNumber;
   }
   
    @Override
    public void run(){

        try {
            client = new Socket(ipString,portNumber);
            output = new PrintWriter(client.getOutputStream(),true);
            input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            InputHandler inHandler = new InputHandler();
            Thread t = new Thread(inHandler);
            t.start();
        } catch (Exception e) {
            // TODO: handle exception
            shutdown();
        }

    } 

    public void shutdown(){
        try {
            input.close();
            output.close();
            if(!client.isClosed()) client.close();
        } catch (Exception e) {
            // ignore
        }
    }


public class InputHandler implements Runnable{

    @Override
    public void run() {
    try {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String message = inputReader.readLine();
            output.println(message);
        }
    } catch (Exception e) {
        shutdown();
    }}

}

public static void main(String[] args){
    Client client = new Client( "127.0.0.1",9990);
    client.run();
    
}

}
