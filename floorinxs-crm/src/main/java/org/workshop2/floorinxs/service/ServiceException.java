package org.workshop2.floorinxs.service;

public class ServiceException extends RuntimeException {
    public ServiceException(){}
    
    public ServiceException(String message) {
        super(message);
    }
    
    public ServiceException(Throwable cause) {
        super(cause);
    }
    
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
