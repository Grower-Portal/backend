package com.growerportal.GrowerPortal.util;

public class CluNotFoundException extends RuntimeException{
    public CluNotFoundException(Long cluId){
        super(STR."Clu with not found with Id: \{cluId}");
    }
}
