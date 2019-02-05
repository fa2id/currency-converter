package com.fa2id.app.file;

/**
 * This is the factory class for FileReader and FileWriter.
 *
 * @author Farid Ariafard
 * www.fa2id.com
 */
public class FileFactory {


    /**
     * This method creates FileReader object.
     *
     * @return FileReader object
     */
    public static FileReader createFileReader() {
        return new FileReaderImplementation();
    }


}
