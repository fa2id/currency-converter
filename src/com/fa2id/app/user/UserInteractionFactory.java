package com.fa2id.app.user;

/**
 * This is the factory class for UserInteraction.
 *
 * @author Farid Ariafard
 * www.fa2id.com
 */
public class UserInteractionFactory {


    /**
     * This method creates UserInteraction object.
     *
     * @return UserInteraction object.
     */
    public static UserInteraction create() {
        return new UserInteractionImplementation();
    }
}
