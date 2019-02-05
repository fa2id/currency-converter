package com.fa2id.app.application;

/**
 * This is the interface for application initializer which initializes using a file.
 * @author farid
 * www.fa2id.com
 */
public interface ApplicationInitializer {

    boolean initializeApplication(String fileName) throws Exception;
}
