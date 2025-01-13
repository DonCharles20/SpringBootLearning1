package com.don.myapp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary//this is used to tell springboot that this is the primary component to use
/*using @Primary on two componets will casuse an error */
@Component
public class Desktop implements Computer {
    @Override
    public void compile(){
        System.out.println("compiling with 404 Bugs but faster");
    }
    
}
