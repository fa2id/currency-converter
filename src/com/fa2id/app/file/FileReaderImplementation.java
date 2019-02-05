package com.fa2id.app.file;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author farid
 * www.fa2id.com
 */
public class FileReaderImplementation implements FileReader {

    @Override
    public String readFileToString(final String fileName) throws FileNotFoundException {
        if (fileName == null || fileName.isEmpty())
            throw new FileNotFoundException("File name is Empty!");
        if (fileName.contains("/") || fileName.contains("\\"))
            throw new FileNotFoundException("File name is not right!");
        StringBuilder stringBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> stringBuilder.append("\n").append(line));
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
        if (stringBuilder.length() > 0)
            stringBuilder.deleteCharAt(0);
        return stringBuilder.toString();
    }
}
