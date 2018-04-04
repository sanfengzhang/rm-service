package com.han.rm.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnApplicationContext extends AnnotationConfigApplicationContext
{

	public SpringAnnApplicationContext(String... basePackages)
	{
		super();
		scan(basePackages);
		refresh();
	}

}
