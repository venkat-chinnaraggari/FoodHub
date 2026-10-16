package com.venkat.dao;

import java.util.List;

import com.venkat.exception.DAOException;
import com.venkat.model.Order;

public interface OrderDAO {

    void save(Order order) throws DAOException;

    void update(Order order) throws DAOException;

    void delete(int orderId) throws DAOException;

    Order findById(int orderId) throws DAOException;

    List<Order> findAll() throws DAOException;
}
