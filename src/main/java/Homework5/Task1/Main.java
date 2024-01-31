package Homework5.Task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        try {
            fileBackup(".", "./backup");
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void fileBackup(String sourceDirectory, String targetDirectory) throws IOException {
        File source = new File(sourceDirectory);
        File target = new File(targetDirectory);

        if (!target.exists()) {
            target.mkdir();
        }

        File[] files = source.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    File backup = new File(target, file.getName());

                    Files.copy(file.toPath(), backup.toPath());
                }
            }
        }
    }
}
