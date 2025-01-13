package com.don.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


/*
Dependency:
It is the relationships between different components or modules of a system 
where one component relies on another to function correctly.
Dependencies can be libraries, frameworks, 
or other modules that a piece of software needs to operate.

Inversion of Control (IoC) is a design principle where the responsibility for creating 
objects and managing their dependencies is transferred from the application or developer 
to a framework or container. This improves flexibility by decoupling components, 
making them easier to reuse and modify.
In traditional programming, developers manage the lifecycle of objects themselves, 
using the new keyword to create instances and manually managing their scope and dependencies. 
This can lead to tightly coupled code and potential inefficiencies.
However, in the Spring Framework (including Spring Boot), this control is inverted. 
The framework manages the lifecycle of objects (known as beans) and their dependencies, 
ensuring they are created, injected, reused, and cleaned up appropriately. 
This reduces boilerplate code, promotes consistency, 
and enables efficient object management based on application requirements.
This is done through depency injection

DI(Dependency injection) implements IOC by providing the required dependencies for the class
without having to create them. Dependencies should be explicit.
There are 3 types of dependencies, 
Constructor Injection: Dependencies are provided via the constructor.
Setter Injection: Dependencies are provided via setter methods.
Field Injection (less preferred): Dependencies are injected directly into the fields using annotations.

why field injection is less preferred than constructor injection?
1.Field injection is harder to test: 
dependencies cannot be mocked or replaced since they are private and cannot be easily set from the outside.

2.Field injection Does not follow DI: 
the Dependencies are Hidden which makes it difficult to see what the class requires to function.
reducing readability and maintainability

3. field injection Causes Immutability concerns:
 objects cannot be marked as final since they are assigned upon creation.
immutable objects (with final fields) are easier to reason about, thread-safe by default, and less error-prone.

4.Field Injection relies on Spring container to initialize dependencies: 
if an object is created outside the Spring container it cannot be injected(in unit tests or non-managed environments)
the dependencies will not be injected, leading to NullPointerException.

5.Field injection Cause compatibility issues: 
some tools such as Lombok since these tools require explicit dependencies
and cannot work with field injection since it provides no way to set the dependencies
and they are implicitly set by the Spring container.

Field injection should only be used for small projects or classes, 
Where Spring container will always manage object creation, 
or rarely changed dependencies like logging. 
Constructor injection is better since it uses explicit dependencies, easy immutability, 
and object lifecycle management



When the Spring application starts, 
it creates an IoC container, 
which is essentially a context where Spring-managed beans (objects) are instantiated, configured, and assembled. 
This container is responsible for injecting dependencies into the beans, 
which is a process known as Dependency Injection (DI). 
The IoC container ensures that the correct dependencies are provided to each bean, 
promoting loose coupling and enhancing the modularity of the application.

when the SpringApplication.run(MyappApplication.class, args) method is called, 
it initializes the Spring IoC container. 
This container then scans the application for components, 
configurations, and services, creating and managing the necessary objects within the JVM. 
This approach simplifies the development process by allowing developers to focus on business logic 
rather than the intricacies of object creation and dependency management. */
@SpringBootApplication
public class MyappApplication {

	public static void main(String[] args) {
		/*Spring creates objects in Java Virtual Machine within the IOC container */
		//SpringApplication.run(MyappApplication.class, args);// This creates and runs the container

		//Dev obj= new Dev(); Manual creation of an object without spring, object life cycle is done manually
		//obj.build();/*This is an example of dependency injection through a method of a class*/

		ApplicationContext context= SpringApplication.run(MyappApplication.class,args);
		
		/* application context vs SpringApplication.run

		 * The ApplicationContext is the central interface within a Spring application for
		 *  providing configuration information to the application.
		 * It is read-only at runtime, but can be reloaded if necessary and supported by the application.
		 * A number of classes implement the ApplicationContext interface,
		 * allowing for a variety of configuration options and types of applications.
		 * 
		 * SpringApplication.run(MyappApplication.class, args) is a static method that starts the Spring application.
		 * It creates an ApplicationContext and runs the application,
		 * handling the lifecycle of the application and managing the beans within the application context.
		 * 
		 * 
		 */

		Dev obj2=context.getBean(Dev.class);
		obj2.build();
		/*a "bean" is an object that is managed by the Spring IoC (Inversion of Control) container. 
		Beans are the fundamental building blocks of a Spring application and are defined, 
		configured, and managed by the Spring container. 
		The Spring container is responsible for managing the lifecycle of beans, 
		including their creation, initialization, and destruction. 
		This allows for consistent and controlled management of application components. */












	}
	





















}
