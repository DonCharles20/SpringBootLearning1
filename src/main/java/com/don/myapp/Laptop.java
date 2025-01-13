package com.don.myapp;

import org.springframework.stereotype.Component;

@Component//laptop component connects to dev
public class Laptop implements Computer {
    @Override
    public void compile(){
        System.out.println("compiling with 404 Bugs");
    }
    
}

/*
 * public void compile(){ 
 * System.out.println("compiling with 404 Bugs"); 
 * }
 */