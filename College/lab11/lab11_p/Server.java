package lab11_p;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) {
        int port = 12345; // Port where the server will listen


        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started, waiting for connection...");


            // Accepting a connection from the client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected to client: " + clientSocket.getInetAddress());


            // Creating communication streams
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);


            // Sending a message to the client
            output.println("Message sent to client");
            System.out.println("Message sent to client, waiting for response...");


            // Reading the response from the client
            String response = input.readLine();
            System.out.println("Client response: " + response);


            // Checking the response
            if ("Communication established and response sent".equals(response)) {
                System.out.println("Valid response, sending confirmation...");
                Thread.sleep(5000); // Wait for 5 seconds
                output.println("Connection approved");
            }

            else {
                System.out.println("Invalid response, shutting down server.");
                clientSocket.close();
                return;
            }


            // Handling further communication
            String finalMessage = input.readLine();
            System.out.println("Final message from client: " + finalMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
