package com.ecommerce.sb_ecom.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class APIResponse {
    public String message;
    private  boolean status;
}
