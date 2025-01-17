package lab11_p;
import java.io.*;
import java.net.Socket;


public class Client {
    public static void main(String[] args) {
        String host = "localhost"; // Server address
        int port = 12345; // Server port


        try (Socket socket = new Socket(host, port)) {
            System.out.println("Connected to server: " + host);


            // Creating communication streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);


            // Reading the first message from the server
            String serverMessage = input.readLine();
            System.out.println("Server: " + serverMessage);


            // Checking the message content and sending a response
            if ("Message sent to client".equals(serverMessage)) {
                output.println("Communication established and response sent");
                System.out.println("Response sent to the server.");
            }


            // Waiting for server confirmation
            String confirmation = input.readLine();
            System.out.println("Server: " + confirmation);


            // Simulating client operation for 120 seconds
            System.out.println("Waiting 120 seconds before shutting down...");
            Thread.sleep(120000);


            // Sending the final message
            output.println("Shutting down");
            System.out.println("Final message sent, closing connection.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
