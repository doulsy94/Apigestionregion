package com.sysy.maliTourist.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*marque une methode ou une classe d'exception avec un code d'état et une
raison qui doivent être retournées*/
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RegionNotFoundException extends  RuntimeException{
    public RegionNotFoundException(String message){
        super(message);
    }
}
