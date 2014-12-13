package com.company;

/**
 * Created by axel on 13/12/14.
 */
public class FeuRougeException extends Exception {
    public FeuRougeException() {
        super();
    }

    public FeuRougeException(String message) {
        super(message);
    }

    public FeuRougeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FeuRougeException(Throwable cause) {
        super(cause);
    }

    protected FeuRougeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
