package com.venkat.service;

import com.venkat.daoImpl.MenuDAOImpl;
import com.venkat.exception.DAOException;
import com.venkat.dao.MenuDAO;
import java.util.List;
import com.venkat.model.Menu;


public class MenuService 
{
	MenuDAO menuDAO = new MenuDAOImpl();
	
	public List<Menu> getMenusByRestaurantId(int restaurantId) throws DAOException
	{
		return menuDAO.getMenusByRestaurantId(restaurantId);
	}
}
