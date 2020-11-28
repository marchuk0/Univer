package com.marchuk0;

import javax.swing.*;
import java.io.IOException;

public class ServerService {
    private static final String errorMessage = "Error";

    private final FileHandler handler = new FileHandler();

    public String handleMessage(String message) {
        String[] parts = message.split(" ");
        switch (parts[0]) {
            case "ls": {
                if (parts.length > 2) return errorMessage;
                if (parts.length == 2) {
                    return String.join("\n", handler.listFileNames(parts[1]));
                } else {
                    return String.join("\n", handler.listFileNames(null));
                }
            }
            case "pwd": {
                try {
                    return handler.getCurPath();
                } catch (IOException e) {
                    return errorMessage;
                }
            }
            case "cd": {
                if (parts.length != 2 || !handler.changeDir(parts[1])) {
                    return errorMessage;
                }
                try {
                    return handler.getCurPath();
                } catch (IOException e) {
                    return errorMessage;
                }
            }
            default: {
                return errorMessage;
            }
        }
    }
}
