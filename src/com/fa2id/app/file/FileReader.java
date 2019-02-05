package com.fa2id.app.file;

import java.io.FileNotFoundException;

/**
 * @author farid
 * www.fa2id.com
 */
public interface FileReader {

    String readFileToString(String fileName) throws FileNotFoundException;
}
