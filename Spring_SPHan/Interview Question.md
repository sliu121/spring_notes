# Spring Interview Question

## What is Spring IOC?

IoC is the core part of Spring. IoC stands for inversion of control. It means that objects do not create other objects on which they rely to do their work. Instead, they get the objects that they need from an outside source. Spring uses Dependency Injection to implement IoC.

## Different types of injection

constructor injection and setter injection

## Bean Scope

We can create Spring beans of scopes as Singleton, Prototype, Request, Session, GlobalSession. 

## Is Logger singleton type?

No. Logger uses factory pattern to create logger instance.

## What is autowire in Spring? Different options for autowire

Autowiring feature of spring framework enables you to inject the object dependency implicitly. It internally uses setter or constructor injection. Different options: no(default), byName, byType, constructor(use type)

1. autowire byName – For this type of autowiring, setter method is used for dependency injection. Also the variable name should be same in the class where we will inject the dependency and in the spring bean configuration file.
2. autowire byType – For this type of autowiring, class type is used. So there should be only one bean configured for this type in the spring bean configuration file.
3. autowire by constructor – This is almost similar to autowire byType, the only difference is that constructor is used to inject the dependency.
4. `@Autowired` annotation – We can use Spring @Autowired annotation for spring bean autowiring. @Autowired annotation can be applied on variables and methods for autowiring **byType**. We can also use @Autowired annotation on constructor for constructor based spring autowiring.

## What is @Qualifier

`@Qualifier` annotation – This annotation is used to avoid conflicts in bean mapping and we need to provide the bean name that will be used for autowiring. This way we can avoid issues where multiple beans are defined for same type. This annotation usually works with the @Autowired annotation. For constructors with multiple arguments, we can use this annotation with the argument names in the method

## Differences between BeanFactory and ApplicationContext

Both are IoC containers in Spring. ApplicationContext extends BeanFactory and has more features. The primary difference is that ApplicationContext will pre-instantiate all of the Singleton beans. BeanFactory supports lazy loading while ApplicationContext supports Aggressive loading. [Comment] Other differences ApplicationContext--Support Annotation based dependency Injection. ApplicationContext- Application contexts can publish events to beans that are registered as listeners. ApplicationContext-Support internationalization (I18N) messages. 

## Workflow of Spring MVC

A request goes through DispatcherServlet, uses @Controller to find a controller class, uses @RequestMapping to find the corresponding method to handle the request, then the method returns a ModelAndView object, in which model contains data and view contains a string that will be converted to a real url by ViewResolver.

## What is AOP? What is difference between AOP and IoC?

AOP stands for Aspect Oriented Programming. It is a programming paradigm that aims to increase modularity by allowing the separation of **cross-cutting concerns**. It does so by adding additional behavior to existing code without modification of the code itself.

## The limitation of Spring AOP

Spring AOP is lightweight AOP implementation. It only support method level joint points.

## What are different advice types in Spring?

Before advice – Run before the method execution. 

After returning advice – Run after the method returns a result.

 After throwing advice – Run after the method throws an exception. 

Around advice – Run around the method execution, combine all three advices above. 

## What is Spring JPA?

JPA(Java Persistence API) is a collection of classes and methods to persistently store the vast amounts of data into a database. It is a specification which can be implemented by various ORM frameworks, like Hibernate, MyBatis. Spring Data JPA focuses on using JPA to store data in a relational database. We normally create interfaces which extends Spring JPARepository.

