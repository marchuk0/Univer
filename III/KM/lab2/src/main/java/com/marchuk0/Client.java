package com.marchuk0;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Logger logger = LoggerFactory.getLogger(Client.class);

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }
    }

    public String sendMessage(String message) {
        out.println(message);
        try {
            return in.readLine();
        } catch (IOException e) {
            logger.debug(e.getMessage());
            return null;
        }

    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner((System.in));

        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);

        String line;
        while ((line = scanner.nextLine()) != null) {
            System.out.println(client.sendMessage(line));
        }
    }
}
