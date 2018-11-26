package br.com.accountmanager.strategy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.accountmanager.service.MenuService;

/**
 * @author Lucas
 *
 */
@Component
@Qualifier(value="MenuStrategyDAO")
public class MenuStrategyDAO implements MenuService {

	@Resource(name = "JsonDAOImpl")
	private MenuService factory;
	
	public MenuStrategyDAO() {
		super();
	}

	@Override
	public String findAllMenu() throws FileNotFoundException, IOException, ParseException {
		return this.factory.findAllMenu();
	}

	@Override
	public String findMenuById(String id) throws FileNotFoundException, IOException, ParseException {
		return this.factory.findMenuById(id);
	}

	@Override
	public String findMenuByRestaurantId(String id) throws FileNotFoundException, IOException, ParseException {
		return this.factory.findMenuByRestaurantId(id);
	}

	@Override
	public void create(Object object) {
		
	}

	@Override
	public void update(Object object) {
	}

	@Override
	public void detele(Object object) {
	}

	@Override
	public List<Object> findAll(Object object) {
		return null;
	}
	

}
