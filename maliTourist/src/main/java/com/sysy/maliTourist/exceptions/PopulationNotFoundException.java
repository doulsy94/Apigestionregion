package com.sysy.maliTourist.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//code associé à une exception
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PopulationNotFoundException extends  RuntimeException {
    public PopulationNotFoundException(String message){
        super(message);
    }

}
