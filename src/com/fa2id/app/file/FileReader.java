package com.fa2id.app.file;

import java.io.FileNotFoundException;

/**
 * This is an interface for reading a file
 * @author farid
 * www.fa2id.com
 */
public interface FileReader {

    /**
     * This method is for reading a file, and return the body of the file as a string.
     *
     * @param fileName is the name of the external file.
     * @return a string which is the exact as the file body after reading.
     * @throws FileNotFoundException if the file is not found.
     */
    String readFileToString(String fileName) throws FileNotFoundException;
}
