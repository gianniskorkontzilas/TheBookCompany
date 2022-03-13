package com.bookcompany.builder.io;

import com.bookcompany.builder.model.Directory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileInputOutput {

    public static List<String> readFile(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            while (true) {
                String s = in.readLine();
                if (s == null)
                    break;
                lines.add(s);
            }
        }
        catch (IOException ioException) {
            System.out.println("Something is fault.");
        }
        return lines;
    }


    public void writeFile(List<String> listToOutput, String filePath) {
        String path = Directory.FILE_DIRECTORY.getPath() + "data" + File.separator + "output" + File.separator + filePath;
        if (new File(path).exists())
            System.err.println("Filename exists.");
        else {
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(path))) {
                for (String str : listToOutput)
                    pw.println(str);
            } catch (IOException ioException) {
                System.out.println("Something is fault.");
                System.out.println(ioException.getMessage());
                System.out.println(ioException.getClass());
            }
        }
    }
}
