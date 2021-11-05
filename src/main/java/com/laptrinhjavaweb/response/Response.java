package com.laptrinhjavaweb.response;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Response {
    private Integer code;
    private String message;
    private Object data = new ArrayList<Object>();

    public Response() {
    	this.code = HTTPStatus.OK.getCode();
    	this.message = HTTPStatus.OK.getMessage();
    }
    
}
