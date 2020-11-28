package com.marchuk0;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.print.DocFlavor;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Logger logger = LoggerFactory.getLogger(Client.class);

    private Socket clientSocket;
    private PrintWriter out;
    private InputStreamReader in;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new InputStreamReader(clientSocket.getInputStream());
        } catch (IOException e) {
            logger.debug(e.getMessage());
        }
    }

    public String sendMessage(String message) {
        out.println(message);
        try {
            while(!in.ready());
            return readAll(in);
        } catch (IOException e) {
            logger.debug(e.getMessage());
            return null;
        }
    }

    private String readAll(Reader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        String input;
        while (reader.ready()) {
            builder.appendCodePoint(reader.read());
        }
        return builder.toString();
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

        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        client.startConnection("127.0.0.1", 6666);

        String line;
        while ((line = scanner.nextLine()) != null) {
            System.out.print(client.sendMessage(line));
        }
        client.stopConnection();
    }
}
