package com.fa2id.app.application;

/**
 * This is the interface for the applications which have to be started in order to give services to the users.
 *
 * @author farid
 * www.fa2id.com
 */
public interface Application {

    /**
     * To start the application, initialization is needed.
     * <p>
     * This initialization will be done using a file acting as database.
     *
     * @param fileName is the name of the external database file. It is used for adding data to database.
     */
    void start(String fileName);
}
