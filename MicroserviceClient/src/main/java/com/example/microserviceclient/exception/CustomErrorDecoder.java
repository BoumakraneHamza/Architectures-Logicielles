package com.example.microserviceclient.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String invoqueur, Response reponse) {
        if(reponse.status() == 400 ) {
            return new ProductBadRequestException(
                    "Requête incorrecte "
            );
        } else if (reponse.status() == 404) {
            return new ProductNotFoundException(
                    "product not found"
            );
        }
        return defaultErrorDecoder.decode(invoqueur, reponse);
    }
}