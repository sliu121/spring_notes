## New features of Java 1.8

[2. New Features in Java language](https://www.javacodegeeks.com/java-8-features-tutorial.html#new_features)

- [2.1. Lambdas and Functional Interfaces](https://www.javacodegeeks.com/java-8-features-tutorial.html#lambdas_and_functional)
- [2.2. Interface Default and Static Methods](https://www.javacodegeeks.com/java-8-features-tutorial.html#Interface_Default)
- [2.3. Method References](https://www.javacodegeeks.com/java-8-features-tutorial.html#method_references)
- [2.4. Repeating annotations](https://www.javacodegeeks.com/java-8-features-tutorial.html#repeating_annotations)
- [2.5. Better Type Inference](https://www.javacodegeeks.com/java-8-features-tutorial.html#better_type_inference)
- [2.6. Extended Annotations Support](https://www.javacodegeeks.com/java-8-features-tutorial.html#extended_annotations_support)

[3. New Features in Java compiler](https://www.javacodegeeks.com/java-8-features-tutorial.html#new_features_in_java)

- [3.1. Parameter names](https://www.javacodegeeks.com/java-8-features-tutorial.html#parameter_names)

[4. New Features in Java libraries](https://www.javacodegeeks.com/java-8-features-tutorial.html#New Features in Java libraries)

- [4.1. Optional](https://www.javacodegeeks.com/java-8-features-tutorial.html#Optional)
- [4.2. Streams](https://www.javacodegeeks.com/java-8-features-tutorial.html#streams)
- [4.3. Date/Time API (JSR 310)](https://www.javacodegeeks.com/java-8-features-tutorial.html#date/Time_API_(JSR 310))
- [4.4. Nashorn JavaScript engine](https://www.javacodegeeks.com/java-8-features-tutorial.html#nashorn_JavaScript_engine)
- [4.5. Base64](https://www.javacodegeeks.com/java-8-features-tutorial.html#base64)
- [4.6. Parallel Arrays](https://www.javacodegeeks.com/java-8-features-tutorial.html#parallel_arrays)
- [4.7. Concurrency](https://www.javacodegeeks.com/java-8-features-tutorial.html#concurrency)

[5. New Java tools](https://www.javacodegeeks.com/java-8-features-tutorial.html#new_java_tools)

- [5.1. Nashorn engine: jjs](https://www.javacodegeeks.com/java-8-features-tutorial.html#nashorn_engine: jjs)
- [5.2. Class dependency analyzer: jdeps](https://www.javacodegeeks.com/java-8-features-tutorial.html#class_dependency_analyzer: jdeps)

[6. New Features in Java runtime (JVM)](https://www.javacodegeeks.com/java-8-features-tutorial.html#new_features_in_Java_runtime_(JVM))

#### **Interface Default and Static Methods**

Starting with Java 8, interfaces can have ***static*** and ***default*** methods that, despite being declared in an interface, have a defined behavior.

***static method in interface:***  cannot be overridden by an implementing class

***default method in interface:***  can be overridden

#### **Method References**

Method reference can be used as a shorter and more readable alternative for a lambda expression which only calls an existing method. 

1. Reference to Static method: ***ContainingClass::methodName***
2. Reference to Instance method: ***containingInstance::methodName***
3. Reference to Instance method of an object of a particular type: ***ContainingType::methodName***
4. Reference to constructor:  ***ClassName::new***

#### Optional<T>

*Optional<T>* class can help to handle situations where there is a possibility of getting the *NPE (NullPointerException)*. It works as a container for the object of type *T.* It can return a value of this object if this value is not a *null*. When the value inside this container is *null* it allows doing some predefined actions instead of throwing *NPE(NullPointerException)*

​	method: 

- **boolean isPresent(): **如果值存在则方法会返回true，否则返回 false
- **static <T> Optional<T> of(T value): **返回一个指定非null值的Optional,如果传递的参数是 null，抛出异常 NullPointerException
- **static <T> Optional<T> ofNullable(T value)**: 如果为非空，返回 Optional 描述的指定值，否则返回空的 Optional
- **T get(): **如果在这个Optional中包含这个值，返回值，否则抛出异常：NoSuchElementException



## how to get current time

- java.time.format.DateTimeFormatter
- java.text.SimpleDateFormat 
- java.time.LocalDate 
- java.time.LocalTime 
- java.time.LocalDateTime 
- java.time.Clock 
- java.util.Date 
- java.sql.Date 
- java.util.Calendar 

##  lambda expression

A lambda expression is a short code which takes in parameters and returns a value, kind of like arrow function in JS. Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.

```java
class Test{
	public static void main(String[] args){
		List<Integer> list = new LinkedList<>();
		for(int i =0;i<5;i++) list.add(i);
		
		System.out.println(list); // -> 0,1,2,3,4
		
		Collections.sort(list, (a,b) -> ( b - a ) ); 
		
		System.out.println(list); //-> 4,3,2,1,0
	}
}
```



## static

*static* is a non-access modifier in Java which is applicable for the following:

1. blocks: A static block that gets executed exactly once, when the class is first loaded
2. variables: When a variable is declared as static, then a single copy of variable is created and shared among all objects at class level. Static variables are, essentially, global variables
3. methods: Any static member can be accessed before any objects of its class are created, and without reference to any object.Methods declared as static have several restrictions:
   - They can only directly call other static methods.
   - They can only directly access static data.
   - They cannot refer to [this](https://www.geeksforgeeks.org/this-reference-in-java/) or [super](https://www.geeksforgeeks.org/super-keyword/) in any way.
   - Static methods cannot access or change the values of instance variables, but they can access or change the values of static variables
4. nested classes

Those static member cannot be declared inside any method, cuz they are belong to the whole class, so we only can declare them out the method. 

## handle exception

An exception is an error event that can happen during the execution of a program and disrupts its normal flow. The exception can arise from different kinds of situations such as wrong data entered by the user, hardware failure, network connection failure, etc.

**Java Exception handling** framework is used to handle runtime errors only, compile-time errors are not handled by exception handling framework.

1. **throw**: Sometimes we explicitly want to create an exception object and then throw it to halt the normal processing of the program. The **throw** keyword is used to throw exceptions to the runtime to handle it.
2. **throws**: When we are throwing any checked exception in a method and not handling it, then we need to use the throws keyword in the method signature to let the caller program know the exceptions that might be thrown by the method. The caller method might handle these exceptions or propagate them to its caller method using the `throws` keyword. We can provide multiple exceptions in the throws clause and it can be used with the **main()** method also.
3. **try-catch**: We use try-catch block for exception handling in our code. try is the start of the block and catch is at the end of the try block to handle the exceptions. We can have multiple catch blocks with a try and try-catch blocks can be nested also. catch block requires a parameter that should be of type Exception.
4. **finally**: The finally block is optional and can be used only with a try-catch block. Since exception halts the process of execution, we might have some resources open that will not get closed, so we can use the finally block. The finally block gets executed always, whether an exception occurs or not.

## optional class

*Optional<T>* class can help to handle situations where there is a possibility of getting the *NPE (NullPointerException)*. It works as a container for the object of type *T.* It can return a value of this object if this value is not a *null*. When the value inside this container is *null* it allows doing some predefined actions instead of throwing *NPE(NullPointerException)*

## is it possible to override a private static method?

No, we cannot override private or static methods in Java. Private methods in Java are not visible to any other class which limits their scope to the class in which they are declared.

## marker interface

A marker interface is an [interface](https://www.baeldung.com/java-interfaces) that **has no methods or constants inside it**. It provides **run-time type information about objects**, so the compiler and JVM have **additional information about the object**.

## Avoid NullPointerException

We can use Optional class, there is method Nullable() with one parameter, it would return null if the parameter is null. 

## joint ? method



## state of thread

ead state. A thread can be in one of the following states:

- [`NEW`](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.State.html#NEW)
  A thread that has not yet started is in this state.
- [`RUNNABLE`](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.State.html#RUNNABLE)
  A thread executing in the Java virtual machine is in this state.
- [`BLOCKED`](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.State.html#BLOCKED)
  A thread that is blocked waiting for a monitor lock is in this state. Imagine I have a person in person meeting in the morning, I have to drive my car to the office, but I find that my girlfriend has driven the car to Walmart, so me as Thread A cannot keep working cuz my girlfriend as Thread B have already acquired it.
- [`WAITING`](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.State.html#WAITING)
  A thread that is waiting indefinitely for another thread to perform a particular action is in this state. For example, I drive my car back to home,  but a cop shows up and pull me over. so currently, me as thread A have to wait cop thread B finish his work, then I can keep moving. 
- [`TIMED_WAITING`](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.State.html#TIMED_WAITING)
  A thread that is waiting for another thread to perform an action for up to a specified waiting time is in this state. Imagine my girlfriend ask me to drive her to Walmart when I go to the office, so I drive to her house and wait her. after 20 mins, she doesnt show up, I cant wait any more, cuz I will late for work, I just drive my car and leave. so me as Thread A, the time I stop the car we can take it as release lock, and I wait up to 20 min, during this time I am Timed_waiting. 
- [`TERMINATED`](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.State.html#TERMINATED)
  A thread that has exited is in this state.



## Deadlock

Say you have two processes P1 and P2  •Both need to acquire two locks L1 and L2 to access a resource. 

•Problem: Deadlock. P1 acquires L1 •P2 acquires L2 •P1 tries to acquire L2 and blocks •P2 tries to acquire L1 and blocks •We have a deadlock!

## avoid deadlock

Lock Ordering, Priority Inversion

## IllegalThreadState

a thread is not in an appropriate state for the requested operation. See, for example, the `suspend` and `resume` methods in class `Thread` 

## DispatcherServlet

It's a front controller, when the request coming to the server, dispatcherservlet will assign the request to the mapped controller, the servlet will receive a render of response from controller, and pass it to View resolver.

## IoC

We always need to create, manage the objects, but spring will do it for us, spring has an IoC container which based on the Dependency Injection, we dont need to create the object,  all we need to do is to describe how those objects should be created 

## Spring MVC



## Exception handle in Spring 

we can use AOP to catch and check those exception.  

for Spring mvc, on the controller level we have ExceptionHandler, also we can use HandleExceptionResolver,  it contains ExceptionHandlerExceptionResolver,  DefaultHandlerExceptionResolver, SimpleMappingExceptionResolver. Also we can custom HandleExceptionResolver just like creating **a new, custom exception resolver**



Microservice features

eureka server

server communicate

Hibernate

Unit Test

Database connection steps

Difference between @Controller and @RESTController

SQL table, SELECT, JOINT

fetch data

provider, consumer

JSON

design pattern

singleton pattern

factory pattern

Find a target number from a singly linked list

Find the largest number from a binary tree