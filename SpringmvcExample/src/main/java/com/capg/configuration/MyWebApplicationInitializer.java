package com.capg.configuration;

//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration;
//import javax.swing.Spring;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//public class MyWebApplicationInitializer implements WebApplicationInitializer{
//
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		
//		System.out.println("in web servlet");
//        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
//        webCtx.register(Spring.class);
//        webCtx.setServletContext(servletContext);
//        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(webCtx));
//        servlet.setLoadOnStartup(1);
//
//        servlet.addMapping("/");
//
//	    }
//}
	




import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {MyWebMVCConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}


