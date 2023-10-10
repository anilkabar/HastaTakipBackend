package com.hastatakip.utils;

import lombok.Data;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.awt.*;

@Data
public class Result<T> {
    private boolean status;
    private String message;
    private T data;

    public Result( boolean status, String message) {
        this.status = status;
        this.message = message;
    }


    public Result( boolean status, String message, T data ) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Result( boolean status, T data) {
        this.status = status;
        this.data=data;
    }


}
