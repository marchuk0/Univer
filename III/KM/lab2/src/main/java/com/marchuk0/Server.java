package com.marchuk0;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.*;

public class Server {
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    private static final String EXIT_STRING = "exit";

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    private ServerService serverService = new ServerService();


    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String input;
            while (!EXIT_STRING.equals(input = in.readLine())) {
                out.println(serverService.handleMessage(input));
            }
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }

    }

    public void stop() {
        try {
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start(6666);
    }
}
