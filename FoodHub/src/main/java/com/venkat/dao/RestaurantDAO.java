package com.venkat.dao;

import java.util.List;

import com.venkat.exception.DAOException;
import com.venkat.model.Restaurant;

public interface RestaurantDAO {

    void save(Restaurant restaurant) throws DAOException;

    void update(Restaurant restaurant) throws DAOException;

    void delete(int restaurantId) throws DAOException;

    Restaurant findById(int restaurantId) throws DAOException;

    List<Restaurant> findAll() throws DAOException;
    
    List<Restaurant> getPopularRestaurants() throws DAOException;
    
    List<Restaurant> getRestaurantsBySearch(String name) throws DAOException;
}
