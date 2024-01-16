package com.growerportal.GrowerPortal.util;

public class CluNotFoundException extends RuntimeException{
    public CluNotFoundException(Long cluId){
        super(String.format("Clu not found with Id: %s", cluId));

    }
}
