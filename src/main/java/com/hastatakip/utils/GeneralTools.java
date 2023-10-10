package com.hastatakip.utils;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GeneralTools {

    public String yetki(String key){

     return "sss";
    }

    public static @NotNull String replace(String key){
        key = key
                .replace('Ç', 'C')
                .replace('Ö', 'O')
                .replace('Ş', 'S')
                .replace('İ', 'I')
                .replace('Ü', 'U')
                .replace('Ğ', 'G')
                .replace('ç', 'c')
                .replace('ö', 'o')
                .replace('ş', 's')
                .replace('ı', 'i')
                .replace('ü', 'u')
                .replace('ğ', 'g');

        return key;

    }

    public static int decrase (int key){
        key=key-1;
     return key;
    }
}
