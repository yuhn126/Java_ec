package com.encore.t0718;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//System.out.println("contextInitialized");
		
		ServletContext application = sce.getServletContext();
		application.setAttribute("book", new Book());
		
	}
	
}
