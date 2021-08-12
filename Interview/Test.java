import java.util.*;

interface View{
	static String sayHello(){
		return "hello";
	}

	default String hello(String name){
		return name + sayHello();
	}
}

class Person implements View{
	String name;
	Person(String name){
		this.name = name;
	}
	public void say(){
		System.out.println(hello(this.name));
		
		System.out.println(hello(this.name));
	}
	
	@Override
	String hello(String name){
		return name + " nothing ";
	}
}

class Test{
	// static int a = 2;
	public static void main(String[] args){
		Person p = new Person("Java");
		p.say();
	}


}

