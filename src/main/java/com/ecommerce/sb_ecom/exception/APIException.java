package com.ecommerce.sb_ecom.exception;

public class APIException  extends  RuntimeException{
    private  static  final  long serialVerionUID=1L;

    public APIException(){

    }
    public APIException(String message){
        super(message);
    }
}
