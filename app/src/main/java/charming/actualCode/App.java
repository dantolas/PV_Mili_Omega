/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package charming.actualCode;

public class App {


    public static void main(String[] args) {
        System.out.println("App started running");
        //Server server = new Server(9990);
        //server.run();
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        JDBC jdbc = new JDBC("jdbc:mysql://localhost:3306/Users");   

    }
}
