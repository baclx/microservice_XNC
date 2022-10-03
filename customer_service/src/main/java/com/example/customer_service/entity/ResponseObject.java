package com.example.customer_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseObject {
    private String status;
    private String description;
    private Object data;
}
