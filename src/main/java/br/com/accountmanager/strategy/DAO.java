package br.com.accountmanager.strategy;

import java.util.List;

/**
 * @author Lucas
 *
 */
public interface DAO {
	public void create(Object object);
	public void update(Object object);
	public void detele(Object object);
	public List<Object> findAll(Object object);
}
