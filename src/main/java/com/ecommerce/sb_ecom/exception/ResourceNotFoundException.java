package com.ecommerce.sb_ecom.exception;

public class ResourceNotFoundException extends RuntimeException {
    String ResourceName;
    String field;
    String fieldName;
    long fieldId;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String field, String resourceName, String fieldName) {
        super(String.format("%s not found with %s: %s",resourceName,field,fieldName));
        this.field = field;
        ResourceName = resourceName;
        this.fieldName = fieldName;
    }
    public ResourceNotFoundException(String field, String resourceName, long fieldId) {
        super(String.format("%s not found with %s: %d",resourceName,field,fieldId));
        this.field = field;
        ResourceName = resourceName;
       this.fieldId=fieldId;
    }
}
