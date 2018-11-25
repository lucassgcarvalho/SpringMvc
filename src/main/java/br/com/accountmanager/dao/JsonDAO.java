package br.com.accountmanager.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

@Repository
public interface JsonDAO {
	public Object read() throws FileNotFoundException, IOException, ParseException;
}
