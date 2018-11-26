package br.com.accountmanager.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import br.com.accountmanager.strategy.DAO;

/**
 * @author Lucas
 *
 */
@Repository
public interface JsonDAO extends DAO{
	public Object read() throws FileNotFoundException, IOException, ParseException;
}
