# 全记录

## Test_01_start

- 新建一个spring项目，可以选择自己导入开发包，也可以在pom.xml中配置

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  
  <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
  
    <groupId>cn.syl</groupId>
    <artifactId>Test_01_start</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>war</packaging>
  
    <name>Test_01_start Maven Webapp</name>
    <!-- FIXME change it to the project's website -->
    <url>http://www.example.com</url>
  
    <properties>
      <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
      <maven.compiler.source>1.8</maven.compiler.source>
      <maven.compiler.target>1.8</maven.compiler.target>
      <spring.version>5.0.2.RELEASE</spring.version>
    </properties>
  
    <dependencies>
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>${spring.version}</version>
      </dependency>
  
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>${spring.version}</version>
      </dependency>
  
      <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>${spring.version}</version>
      </dependency>
  
      <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>servlet-api</artifactId>
        <version>2.5</version>
        <scope>provided</scope>
      </dependency>
  
      <dependency>
        <groupId>javax.servlet.jsp</groupId>
        <artifactId>jsp-api</artifactId>
        <version>2.0</version>
        <scope>provided</scope>
      </dependency>
  
      <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.11</version>
        <scope>test</scope>
      </dependency>
    </dependencies>
  
    <build>
      <finalName>Test_01_start</finalName>
      <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
        <plugins>
          <plugin>
            <artifactId>maven-clean-plugin</artifactId>
            <version>3.1.0</version>
          </plugin>
          <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
          <plugin>
            <artifactId>maven-resources-plugin</artifactId>
            <version>3.0.2</version>
          </plugin>
          <plugin>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.8.0</version>
          </plugin>
          <plugin>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.1</version>
          </plugin>
          <plugin>
            <artifactId>maven-war-plugin</artifactId>
            <version>3.2.2</version>
          </plugin>
          <plugin>
            <artifactId>maven-install-plugin</artifactId>
            <version>2.5.2</version>
          </plugin>
          <plugin>
            <artifactId>maven-deploy-plugin</artifactId>
            <version>2.8.2</version>
          </plugin>
        </plugins>
      </pluginManagement>
    </build>
  </project>
  
  ```

  

- 在web.xml文件中配置DispatchServlet

```xml
 <servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:springmvc.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>

  <servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>
```

- 在resource文件下，配置springmvc.mxl文件，它用于配置大环境 *(经过上面的配置，系统会自动默认存在一个默认文件<servlet-name>-servlet.xml，它的默认位置是在WEB-INF下。这里我们在其他地方重写了这个配置文件 )*。当本文件加载后，springMVC就会根据扫描组件找到控制层

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:mvc = "http://www.springframework.org/schema/mvc"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/mvc
       http://www.springframework.org/schema/mvc/spring-mvc.xsd
       http://www.springframework.org/schema/context
http://www.springframework.org/schema/context/spring-context.xsd">

<!--  开启注解扫描，将加上@Controller注解的类作为springMVC的控制层  -->
    <context:component-scan base-package="cn.syl" />
<!--  视图解析器，通过控制器返回的值来在配置中寻找视图  -->
    <bean id = "internalResourceViewResolver" class = "org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/pages/" />
        <property name="suffix" value=".jsp" />
    </bean>

<!--  开启 SpringMVC 框架注解的支持  -->
    <mvc:annotation-driven />
</beans>
```

- 创建一个POJO，在此类上加上@Controller注解，springMVC就会将此类作为控制层加载，让其处理请求响应

- 在控制层中，需要在方法上设置@RequestMapping(value/path = "hello")，springMVC就是通过此注解将请求路径与控制层中的方法进行匹配，此时请求路径为 *localhost:8080/projectName/hello*

- 处理请求的方法会返回一个字符串，即视图名称，最终会通过配置文件中配置的视图解析器实现实现页面跳转, 即 prefix + 返回字符串 + suffix


``` java
@Controller
public class HelloController {
    /**
     * // @RequestMapping 中的path路径加不加 / 都可以运行, 直接在括号内加入响应page就行了
     * @return
     */
    @RequestMapping(path = "hello")
    public String sayHello(){
        System.out.println("hello SpringMVC");
        return "success";
    }

    @RequestMapping(path = "/testRequestMapping")
    public String testRequestMapping(){
        System.out.println("This is testRequestMapping");
        return "success";
    }

    @RequestMapping("heya")
    public String testHeya(){
        System.out.println("This is test for no path mentioned in () ");
        return "success";
    }
}
```



## Test_02

### RequestMapping

@RequestMapping: 设置请求映射，把请求和控制层中的方法设置映射关系, 当请求路径和 @RequestMapping的 value属性值一致时，则该注解所标注的方法即为处理请求的方法

method: 用来设置请求方式，只有客户端发送请求的方式和method的值一致，才能处理请求
 请求方法：GET->查询, POST->添加,  PUT->修改, DELETE->删除

params: 用来设置客户端传到服务器的数据，支持表达式
         params={
              "username" -> 必须有该参数
              "！username" -> 不能有该参数
              "username = admin" -> 参数的值必须是 admin
              "username != admin" -> 参数的值不可以是 admin
         }

headers: 用来设置请求头信息，所发送的请求的header必须要和此处设置的header保持一致

```java
   	@RequestMapping(value = "/test",
            method = RequestMethod.POST
//            params = {"username","age != 12"}
//            headers = {"..."}
            )
    public String testPOST(){
        System.out.println("Success: POST");
        return "success";
    }
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String testGet(){
        System.out.println("Success: GET");
        return "success";
    }
```

springMVC 支持使用ant标识来标识路径层级：
     *：标识一个层级      
     **：零个或多个层级
     ？：标识层级的单个符，

 通过使用占位符服务器可以获取传递参数：
      原本的数据接收：localhost:8080/test?id=123&username=admin
      现在的数据接收：localhost:8080/test/123/admin

```java
    @RequestMapping("/**/testREST/{id}/{username}")
    public String testPath(
            @PathVariable("id")Integer id,
            @PathVariable("username")String username
    ){
        System.out.println(id + ": " + username);
        return "success";
    }
```

### HiddenHttpMethodFilter(Put, Delete的实现方式)

对于jsp网页来说(暂时只知道这个)，网页仅支持Get 和 POST，对于PUT和Delete是不支持的(可以理解为，在jsp网页中form表单没有put, delete对应的method)。Post, Put, Delete我们都把他归为POST操作。(理论上，我们也确实可以通过POST来实现其余两个的操作)

可是如果我们就是想用Put和Delete的话，我们需要HiddenHttpMethodFilter 过滤器。

***为什么是过滤器而不是监听器*：因为在载入过程中过滤器的优先载入级别高于监听器，方便我们操作**

该filter的实现方式为：

1. 判断当前方法是不是POST，因为网页只用GET和POST两种方法
2. 当前请求中是否包含一个叫参数名为：_method的变量，如果有，对该 _method的value和控制器的method值做判断，并找到对应的控制器方法。如果没有找到对应控制器，网页报错：**HTTP Status 405 – 方法不允许，请求行中接收的方法由源服务器知道，但目标资源不支持**。

![image-20210419232209829](G:\master_courses\Learning_JavaEE\outside_Libs\mySpringMVC\imgFormd\HiddenHttpMehodFilter.png)



 **实现Put代码如下(Delete 同理)：**

jsp网页：

```jsp
<form action="testREST" method="POST">
    <input type="submit" value="TEST POST">
</form>

<br>
<form action="testREST" method="POST">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="TEST PUT">
</form>
```

控制器.java

```java
@RequestMapping(value = "/testREST",method = RequestMethod.POST)
public String insertUser(){
    System.out.println("POST");
    return "success";
}

@RequestMapping(value = "/testREST",method = RequestMethod.PUT)
public String UpdateUser(){
   System.out.println("PUT");
   return "redirect:/success";
}

@RequestMapping(value = "/success")
public String success(){
    return "success";
}
```

我在自己测试中发现如下问题：

```
项目是运行在 Tomcat 8 及以上，
会发现发出的 PUT 请求和 DELETE 请求可以被控制其接收到，
但是返回页面时（forward）会报HTTP 405 的错误提示：

“消息 JSP 只允许 GET、POST 或 HEAD。Jasper 还允许OPTIONS”。

解决方法：

1. 使用Tomcat 8以下版本
2. 使用 @RestController 或者 @Controller + @ResponseBody, 但是这样无法实现页面跳转
3. 使用重定向 redirect 方式跳转到另一个控制器方法，用这个控制器方法跳转页面(我就是用的这个方法)
4. 给Tomcat添加启动参数，让Tomcat允许写操作
		<init-param>
    		<param-name>readonly</param-name>
    		<param-value>false</param-value>
		</init-param>
5. 创建一个新的 Filter 来过滤 FORWARD
		HiddenHttpMethodFilter 中的 doFilterInternal 方法是用来过滤 form 表单中 name 为 _method		  的请求。可以发现，它把请求作为参数传进HttpMethodRequestWrapper 中并且返回了一个新的请求，放行的		  也是新的请求。所以我们可以重写 HttpMethodRequestWrapper 中的 getMethod() 方法，让它支持 			forward 方式的跳转。
```

### **数据传输方式**

在springMVC获取客户端传递的数据的方式：

jsp代码：

```jsp
<body>
    <form action="param" method="post">
        user name: <input type="text" name="name"/><br>
        password: <input type="password" name="Password"/><br>
        age: <input type="text" name="age"/><br>
        State: <input type = "text" name="state"><br>
        County: <input type = "text" name="county"><br>
        <input type="submit" value="submit">
    </form>
</body>
```

#### 直接使用

在处理请求的方法中，加入相对应的形参，保证形参的参数名和传递的数据的参数名保持一致，就可以自动赋值

```java
@RequestMapping(value = "/param", method = RequestMethod.POST)
public String testSFoward(String name, String Password,String age, String state, String county){
    System.out.println("name: " + name);
    System.out.println("pwd: " + Password);
    System.out.println("age: " + age );
    System.out.println("state: " + state);
    System.out.println("county: " + county);

    return "success";
}
```

#### @PathVariable 

上文，在介绍标识符的时候我们其实用到了这个方法：

```java
@RequestMapping("/**/testREST/{id}/{username}")
public String testPath(
        @PathVariable("id")Integer id,
        @PathVariable("username")String username
){
   		System.out.println(id + ": " + username);
    	return "success";
	}
```

将需要传输的参数从路径上直接获取，通过***@PathVariable("参数名") 变量属性 方法中的参数名*** 来直接获取对应的参数

#### @RequstParam

使用 @RequestParam 可以解决：

1. value: 将请求传递来的参数和当前形参弄成一个mapping
2. required：该参数是不是必须的，默认下为true
3. defaultValue: 若请求传递来的参数值为 null, 我们用它来设定一个值，常用于分页和模糊查询

```java
	@RequestMapping(value = "/param", method = RequestMethod.POST)
    public String testParam(@RequestParam(value = "name", required = false, defaultValue = "admin") String userName, String Password, String Age){
        System.out.println("username: "+ userName+", Password: "+ Password + ", Age: " + Age);
        return "success";
    }
```

#### 使用POJO类

使用POJO实体类对象来获取客户端数据，要求实体类对象中的属性名一定要和页面中表单元素的name属性一致，但是非大小写敏感，而且支持级联关系(也就是用 . 标识)

jsp代码更改成：

```jsp
<body>
    <form action="param" method="post" modelAttribute = "User">
        user name: <input type="text" name="name"/><br>
        password: <input type="password" name="Password"/><br>
        age: <input type="text" name="age"/><br>
        State: <input name="address.state"><br>
        County: <input name="address.county"><br>
        <input type="submit" value="submit">
    </form>
</body>
```

java代码：

```java
@RequestMapping(value = "/param", method = RequestMethod.POST)
public String testCValue(@ModelAttribute(value = "User") User user){
    System.out.println(user.toString());
    return "success";
}
```

此处@ModelAttribute可有可无，@ModelAttribute最主要的作用是将数据添加到模型对象中，用于视图页面展示时使用。[详细内容](https://blog.csdn.net/leo3070/article/details/81046383)

