package com.venkat.service;

import com.venkat.daoImpl.RestaurantDAOImpl;
import com.venkat.exception.DAOException;
import com.venkat.model.Restaurant;

import java.util.List;

import com.venkat.dao.RestaurantDAO;

public class RestaurantService 
{
	 RestaurantDAO restaurantDao = new RestaurantDAOImpl();
	
	 public void save(Restaurant restaurant) throws DAOException
	 {
		restaurantDao.save(restaurant);
	 }
	 
	 public void update(Restaurant restaurant) throws DAOException
	 {
		 restaurantDao.update(restaurant);
	 }
	 
	 public void delete(int restaurantId) throws DAOException
	 {
		 restaurantDao.delete(restaurantId);
	 }
	 
	 public Restaurant findById(int restaurantId) throws DAOException
	 {
		 return restaurantDao.findById(restaurantId);
	 }
	 
	 public List<Restaurant> findAll() throws DAOException
	 {
		 return restaurantDao.findAll();
	 }
	 
	 public List<Restaurant> popularRestaurants() throws DAOException
	 {
		 return restaurantDao.getPopularRestaurants();
	 }
	 
	 public List<Restaurant> getRestaurantsBySearch(String name) throws DAOException
	 {
		 return restaurantDao.getRestaurantsBySearch(name);
	 }
}
