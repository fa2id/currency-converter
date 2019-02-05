package com.fa2id.app.application;

/**
 * This is the interface for application initializer which initializes using a file.
 *
 * @author Farid Ariafard
 * www.fa2id.com
 */
public interface ApplicationInitializer {

    /**
     * This method is for initializing application using an external database file to fill the database.
     *
     * @param fileName is the name of the external database file. It is used for adding data to database.
     * @return true if the initialization is done successfully.
     * @throws Exception if there is any error related to the loading files or adding data to database.
     */
    boolean initializeApplication(String fileName) throws Exception;
}
