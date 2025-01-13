package com.don.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component/*This annotation is used to mark a Java class as a Spring-managed component. 
When a class is annotated with @Component, 
it indicates that the class is a candidate for auto-detection 
and auto-configuration by the Spring IoC container. This helps simplify the development process by
increasing focus on Business logic than object creation and dependency management

this notfies the Autowired that there is another object connected to the type, a dependency required for it to work*/
public class Dev {// dev componet connects to laptop


    Laptop laptop;//this is an instance varible, is set to null by default
    /*causes a null pointer exception if used as is */
    Laptop laptop2 = new Laptop();//creates a new laptop object, new objects are created through setters and constructors

    @Autowired/*This is a field injection:the @autowired annotation in Spring is used for automatic dependency injection. '
    It allows Spring to resolve and inject collaborating beans into your bean. 
    This annotation can be applied to constructors, fields, setter methods, and configuration methods. 
    Autowired looks at the type not the name of the varible. example: .1 is of type double, 1 is of type int
    If there are two different components connected to the type there will be a confusion where springboot
    does not know which to pick
     */
    @Qualifier("laptop")/*This is used to specify which component to use when there are two components connected to the same type 
    can be used in all three injectors and is able to promote the efficeny of loose coupling, 
    in some cases you can just switch varible types instead of using @Qualifer but can cause tight coupling*/
    private Computer fieldComp;//computer is an interface but will use either the laptop or desktop class


    private final Computer constuctorComp;
    /*This is a constructor injection */
    public Dev(@Qualifier("desktop") Computer laptop) {
        this.constuctorComp = laptop;/*
        constrcutor injections do not need the @Autowired*/
    }

    private Computer setterComp;
    @Autowired/*A setter injection but required 
    @Autowired */
    @Qualifier("laptop")/*This is used to specify which component to use when there are two components connected to the same type */
    public void setLaptop(Computer desktop) {
        this.setterComp = desktop;
    }

    @Autowired
    private Computer defaultComp;

    /*Constructors and setter injectors are preferred */

    public void build() {
        try {
            laptop.compile();
        } catch (NullPointerException e) {
            System.out.println("\n laptop is null");
        }
        System.out.print("\n laptop2: ");
        laptop2.compile();

        System.out.print("\n Field Computer: ");
        fieldComp.compile();

        System.out.print("\n Constructor Computer: ");
        constuctorComp.compile();

        System.out.print("\n Setter Computer: ");
        setterComp.compile();

        System.out.print("\n Default Computer: ");
        defaultComp.compile();
        
    }
}
