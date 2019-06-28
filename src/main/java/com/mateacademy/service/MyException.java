package com.mateacademy.service;

import org.apache.log4j.Logger;

public class MyException extends Throwable {
    private static final Logger LOGGER = Logger.getLogger(MyException.class);

    public void exception(Long personId) throws MyException{
        LOGGER.error("There i no person with id " + personId);
    }
}
