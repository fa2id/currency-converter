package com.fa2id.app.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * This class is a fileReader implementation which is for reading from a file.
 *
 * @author farid
 * www.fa2id.com
 */
public class FileReaderImplementation implements FileReader {

    /**
     * This method is for reading a file, and return the body of the file as a string.
     *
     * @param fileName is the name of the external file.
     * @return a string which is the exact as the file body after reading.
     * @throws FileNotFoundException if the file is not found.
     */
    @Override
    public String readFileToString(final String fileName) throws FileNotFoundException {
        if (fileName == null || fileName.isEmpty())
            throw new FileNotFoundException("File name is Empty!");
        if (fileName.contains("/") || fileName.contains("\\"))
            throw new FileNotFoundException("File name is not right!");
        final StringBuilder stringBuilder = new StringBuilder();
        try (final Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> stringBuilder.append("\n").append(line));
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
        if (stringBuilder.length() > 0)
            stringBuilder.deleteCharAt(0);
        return stringBuilder.toString();
    }
}
