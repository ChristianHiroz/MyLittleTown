package com.company;

/**
 * Created by axeleroy on 20/11/2014.
 */
public class PortionOccupedException extends Exception {
    public PortionOccupedException() {
        super();
    }

    public PortionOccupedException(String message) {
        super("Portion occupée");
    }

    public PortionOccupedException(String message, Throwable cause) {
        super(message, cause);
    }

    public PortionOccupedException(Throwable cause) {
        super(cause);
    }

    protected PortionOccupedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
