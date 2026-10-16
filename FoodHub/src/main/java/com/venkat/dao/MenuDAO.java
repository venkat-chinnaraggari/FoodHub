package com.venkat.dao;

import java.util.List;

import com.venkat.exception.DAOException;
import com.venkat.model.Menu;

public interface MenuDAO {

    void save(Menu menu) throws DAOException;

    void update(Menu menu) throws DAOException;

    void delete(int menuId) throws DAOException;

    Menu findById(int menuId) throws DAOException;

    List<Menu> findAll() throws DAOException;
    
    List<Menu> getMenusByRestaurantId(int restaurantId)throws DAOException;
}
