Instructions: Your task is to create a Java application that implements a simple dependency injection framework. Follow the steps outlined below to complete the assignment.
    
1.  Define the Classes: 
	- Create an interface called "DependencyInjector" with a single method "void injectDependencies(Object target)". 
	- Implement the "DependencyInjector" interface with a class called "MyDependencyInjector" that provides an implementation for the "injectDependencies" method.
2.  Implement the Dependency Injection Framework: 
	- Create a class called "Container" that acts as the dependency injection container. 
	- Add a private field in the "Container" class to store a mapping of dependencies. 
	- Implement a method in the "Container" class, e.g., "registerDependency(Class<?> clazz)", to register dependencies. 
	- Implement the "injectDependencies" method in the "MyDependencyInjector" class to perform the actual dependency injection.
    -   Use reflection to scan the target object's fields and identify the ones that are annotated with your custom injection annotation.
    -   Retrieve the corresponding dependency from the "Container" class and set it in the target object's field.
    -   Handle any exceptions that may occur during the injection process.
3.  Define the Classes to be Injected: 
	- Create a class called "UserService" with a private field of type "UserRepository". 
	- Annotate the "UserService" class field with your custom injection annotation.
    
4.  Test the Dependency Injection: 
	- In the main method of your application, create an instance of the "UserService" class. 
	- Create an instance of the "Container" class and register the "UserRepository" as a dependency. 
	- Create an instance of the "MyDependencyInjector" class and call the "injectDependencies" method, passing the "UserService" instance. 
	- Verify that the "UserService" object has the "UserRepository" dependency properly injected.
    
5.  Additional Functionality (Optional):
	- Implement another class and define additional dependencies. 
	- Modify the "Container" and "MyDependencyInjector" classes to support injecting dependencies into the new class. 
	- Test the updated implementation to ensure that the new dependencies are correctly injected.
