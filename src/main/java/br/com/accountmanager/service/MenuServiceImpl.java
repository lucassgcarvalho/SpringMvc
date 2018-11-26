package br.com.accountmanager.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.accountmanager.StrategyService;
import br.com.accountmanager.exceptions.StrategyException;
import br.com.accountmanager.strategy.Strategy;

/**
 * @author Lucas
 */
@Service
@Qualifier(value="MenuServiceImpl")
public class MenuServiceImpl implements MenuService{

	private final static Logger LOGGER = Logger.getLogger(MenuServiceImpl.class);
	
	/*@Autowired
	@Qualifier(value="MenuStrategyDAO")
	private MenuStrategyDAO menuStrategyDAO;
*/	
	@Autowired
	@Qualifier(value="Strategy")
	@StrategyService(value="MenuService")
	private Strategy strategy;
	
    public MenuServiceImpl() {
    	super();
    }
    
    /**
     * Method returns all restaurants 
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public String findAllMenu() throws FileNotFoundException, IOException, ParseException {
    	try {
			return ((MenuService) this.strategy.getStrategy()).findAllMenu();
		} catch (StrategyException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
		}
    	return null;
    }

    /**
     * Method returns all restaurants by id 
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
	public String findMenuById(String id) throws FileNotFoundException, IOException, ParseException {
		try {
			return ((MenuService) this.strategy.getStrategy()).findMenuById(id);
		} catch (StrategyException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
		}
    	return null;
	}

	/**
     * Method returns all menus by restaurant id  
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
	public String findMenuByRestaurantId(String id) throws FileNotFoundException, IOException, ParseException {
		try {
			return ((MenuService) this.strategy.getStrategy()).findMenuByRestaurantId(id);
		} catch (StrategyException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			e.printStackTrace();
		}
    	return null;
	}


	@Override
	public void create(Object object) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void detele(Object object) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Object> findAll(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
