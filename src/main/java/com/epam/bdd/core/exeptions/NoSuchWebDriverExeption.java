package com.epam.bdd.core.exeptions;

public class NoSuchWebDriverExeption extends RuntimeException{
    public NoSuchWebDriverExeption(String message) {
        super(message);
    }
}
