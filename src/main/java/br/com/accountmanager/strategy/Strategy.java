package br.com.accountmanager.strategy;

import java.lang.reflect.Field;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.accountmanager.StrategyService;
import br.com.accountmanager.exceptions.StrategyException;
import br.com.accountmanager.service.MenuService;
import br.com.accountmanager.service.RestaurantService;

@Component
@Qualifier("Strategy")
public class Strategy {
	
	@Resource(name = "JsonDAOImpl")
	private MenuService menuServiceFactory;
	
	@Resource(name = "JsonDAOImpl")
	private RestaurantService restaurantServiceFactory;
	
	private String strategyService;
	
	public Strategy() {
	}

	public Object getStrategy() throws StrategyException, ClassNotFoundException {
		
		strategyService = getCallerMethodServicesName();
		
		if(strategyService.equals(RestaurantService.class.getSimpleName())) {
			return 	restaurantServiceFactory;
		}
		if(strategyService.equals(MenuService.class.getSimpleName())) {
			return 	menuServiceFactory;
		}
		
		throw new StrategyException("Can't load factory");
	}
	
	
	/**
	 * get the value of parameter from annotation of Service placed in the @StrategyService(value='MY_SERVICE_NAME') 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws StrategyException
	 */
	public String getCallerMethodServicesName() throws ClassNotFoundException, StrategyException { 
	    StackTraceElement[] stackThread = Thread.currentThread().getStackTrace();
	    String callerClassName = null;
	    for (int i=1; i<stackThread.length; i++) {
	        StackTraceElement stackElement = stackThread[i];
	        if (!stackElement.getClassName().equals(Strategy.class.getName()) && stackElement.getClassName().indexOf("java.lang.Thread")!=0) {
	            if (callerClassName==null) {
	                callerClassName = stackElement.getClassName();
	            } else if (!callerClassName.equals(stackElement.getClassName())) {
	            	callerClassName = stackElement.getClassName();
	            }
	            
	            for (Field field : Class.forName(callerClassName).getDeclaredFields()) {
                	if (field.isAnnotationPresent(StrategyService.class)){
                		return field.getAnnotation(StrategyService.class).value();
                	}
				}
	        }
	    }
	   
	   throw new StrategyException("Can't Find Strategy service Located in Annotation @StrategyService(value=MY_SERVICE_NAME)");
	 }
	
}
