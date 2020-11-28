package com.marchuk0;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandler {
    private static final String initPath = "/home/olexander";
    File stateFile = new File(initPath);

    List<String> listFileNames(String pattern) {
        Stream<File> fileStream = Arrays.stream(Objects.requireNonNull(stateFile.listFiles()).clone());
        if (pattern != null) {
            fileStream = fileStream.filter(file -> file.getName().contains(pattern));
        }
        return fileStream
                .map(file -> file.isDirectory() ? "/" + file.getName() : file.getName())
                .collect(Collectors.toList());
    }

    boolean changeDir(String dir) {
        File newfile = new File(stateFile, dir);
        if (newfile.exists() && newfile.isDirectory()) {
            stateFile = newfile;
            return true;
        }
        return false;
    }

    String getCurPath() throws IOException {
        return stateFile.getCanonicalPath();
    }
}
