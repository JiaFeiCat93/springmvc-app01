package com.qetch.springmvc.test;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qetch.springmvc.bean.Product;

public class MainTest {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring-config.xml"});
		/**
		 * <bean name="product" class="com.qetch.springmvc.bean.Product"/>
		 * 该bean的定义告诉Spring通过默认无参的构造器来初始化Product类。如果不存在该构造器（如果类作者重载了构造器，且没有显示声明默认构造器），
		 * 则Spring将抛出一个异常。
		 * java.lang.NoSuchMethodException: com.qetch.springmvc.bean.Product.<init>()
		 */
		Product product = context.getBean("product", Product.class);
		product.setName("Excellent snake oil");
		System.out.println("product: " + product.getName()); // product: Excellent snake oil
		
		Calendar calendar = context.getBean("calendar", Calendar.class);
		System.out.println(calendar.getTime()); // Fri Jan 04 10:57:51 CST 2019
		
		ExecutorService executorService = context.getBean("executorService", ExecutorService.class);
		System.out.println(executorService.isShutdown()); // false
		
		Product product1 = context.getBean("product1", Product.class);
		System.out.println(product1); // Product [name=Ultimate Olive Oil, description=The purest olive oil on the market, price=9.95]
		
		Product product2 = context.getBean("product2", Product.class);
		System.out.println(product2); // Product [name=Ultimate Olive Oil2, description=The purest olive oil on the market2, price=9.952]
	}
}
