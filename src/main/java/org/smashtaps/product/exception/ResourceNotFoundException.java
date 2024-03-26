package org.smashtaps.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(String resourceId){
        super("Resource Not found for id: "+resourceId);
    }
}
