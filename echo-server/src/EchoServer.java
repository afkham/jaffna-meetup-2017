/**
 * Created by azeez on 5/23/17.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;

public class EchoServer {

    public static void main(String[] args) throws Exception {

        // create socket
        int port = 4444;
        ServerSocket serverSocket = new ServerSocket(port);
        System.err.println("Started server on port " + port);
        try {
            while (true) {
                Socket client = serverSocket.accept();
                BufferedReader r = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter w = new PrintWriter(client.getOutputStream(), true);
                w.println("Welcome to the Java EchoServer.  Type 'bye' to close.");
                String line;
                do {
                    line = r.readLine();
                    if (line != null) {
                        System.out.println("Got from client: " + line);
                        w.println("Got: " + line);
                    }
                } while (line != null && !line.trim().equals("bye"));
                client.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


