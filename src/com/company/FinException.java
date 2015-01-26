package com.company;

/**
 * Created by Fluttershy on 21/11/2014.
 */
public class FinException extends Exception {
    public FinException() {
        super();
    }

    public FinException(String message) {
        super("Fin");
    }

    public FinException(String message, Throwable cause) {
        super(message, cause);
    }

    public FinException(Throwable cause) {
        super(cause);
    }

    protected FinException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
