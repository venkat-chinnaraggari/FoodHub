package com.venkat.dao;
import java.util.List;

import com.venkat.exception.DAOException;
import com.venkat.model.User;

public interface UserDAO {

    void save(User user) throws DAOException;

    void update(User user) throws DAOException;

    void delete(int userId) throws DAOException;

    User findById(int userId) throws DAOException;
    
    User findByEmail(String email) throws DAOException;

    List<User> findAll() throws DAOException;
}
