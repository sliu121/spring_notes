package com.syl.helloworld;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 用来标注一个主程序类，说明这是一个SpringBoot应用
public class MainApp {
    public static void main(String[] args) {
//        SpringBootApplication.run(MainApp.class, args);
        SpringApplication.run(MainApp.class, args);
    }
}
