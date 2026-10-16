package com.venkat.dao;

import java.util.List;

import com.venkat.exception.DAOException;
import com.venkat.model.OrderItem;

public interface OrderItemDAO {

    void save(OrderItem orderItem) throws DAOException;

    void update(OrderItem orderItem) throws DAOException;

    void delete(int orderItemId) throws DAOException;

    OrderItem findById(int orderItemId) throws DAOException;

    List<OrderItem> findAll() throws DAOException;
}
