package org.rbnk.example.exception;

public class CakeException extends Exception{

    public CakeException() {
        super();
    }

    public CakeException(String message) {
        super(message);
    }

    public CakeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CakeException(Throwable cause) {
        super(cause);
    }
}
