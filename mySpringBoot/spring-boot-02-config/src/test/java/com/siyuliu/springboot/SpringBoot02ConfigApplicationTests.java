package com.siyuliu.springboot;

import com.siyuliu.springboot.bean.Person;
import com.siyuliu.springboot.service.HellowService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot 单元测试
 *
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot02ConfigApplicationTests {
	@Autowired
	Person person;

	@Autowired
	ApplicationContext ioc;

	@Test
	void helloService(){
		boolean b = ioc.containsBean("hellowService02");
		System.out.println(b);

	}

	@Test
	void contextLoads() {
		System.out.println(person.toString());
	}

}
