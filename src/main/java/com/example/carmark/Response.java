package com.example.carmark;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Data
@SuperBuilder
public class Response {
    private String message;
    private String status;
    private String code;
    private Map<?,?> data;
    private String developerMessage;




}
