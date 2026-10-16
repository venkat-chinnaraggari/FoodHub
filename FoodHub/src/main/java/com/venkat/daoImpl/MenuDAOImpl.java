package com.venkat.daoImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.venkat.dao.MenuDAO;
import com.venkat.exception.DAOException;
import com.venkat.model.Menu;
import com.venkat.utility.DBConnectionUtil;

public class MenuDAOImpl implements MenuDAO {

    @Override
    public void save(Menu menu) throws DAOException {
        String sql = "INSERT INTO Menu (RestaurantID, ItemName, Description, Price, IsAvailable, " +
                "ImagePath) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, menu.getRestaurantId());
            ps.setString(2, menu.getItemName());
            ps.setString(3, menu.getDescription());
            ps.setBigDecimal(4, menu.getPrice());
            ps.setBoolean(5, menu.getIsAvailable());
            ps.setString(6, menu.getImagePath());

            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    menu.setMenuId(keys.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new DAOException("Error saving Menu: " + menu, e);
        }
    }

    @Override
    public void update(Menu menu) throws DAOException {
        String sql = "UPDATE Menu SET RestaurantID = ?, ItemName = ?, Description = ?, Price = ?, " +
                "IsAvailable = ?, ImagePath = ? WHERE MenuID = ?";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, menu.getRestaurantId());
            ps.setString(2, menu.getItemName());
            ps.setString(3, menu.getDescription());
            ps.setBigDecimal(4, menu.getPrice());
            ps.setBoolean(5, menu.getIsAvailable());
            ps.setString(6, menu.getImagePath());
            ps.setInt(7, menu.getMenuId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error updating Menu with id " + menu.getMenuId(), e);
        }
    }

    @Override
    public void delete(int menuId) throws DAOException {
        String sql = "DELETE FROM Menu WHERE MenuID = ?";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, menuId);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error deleting Menu with id " + menuId, e);
        }
    }

    @Override
    public Menu findById(int menuId) throws DAOException {
        String sql = "SELECT * FROM Menu WHERE MenuID = ?";

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, menuId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }

        } catch (SQLException e) {
            throw new DAOException("Error finding Menu with id " + menuId, e);
        }

        return null;
    }

    @Override
    public List<Menu> findAll() throws DAOException {
        String sql = "SELECT * FROM Menu";
        List<Menu> menus = new ArrayList<>();

        try (Connection conn = DBConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                menus.add(mapRow(rs));
            }

        } catch (SQLException e) {
            throw new DAOException("Error fetching all Menus", e);
        }

        return menus;
    }
    
    public List<Menu> getMenusByRestaurantId(int restaurantId) throws DAOException
    {
    	String sql = "SELECT * FROM menu WHERE RestaurantId = ?";
    	List<Menu> menusByRestaurantId = new ArrayList<>();
    	
    	try (Connection conn = DBConnectionUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
               ) {
    		
    		ps.setInt(1, restaurantId);

            try(ResultSet rs = ps.executeQuery();)
            {
            	while(rs.next())
            	{
            		menusByRestaurantId.add(mapRow(rs));
            	}
            }
            catch(SQLException a)
            {
            	throw new DAOException("Error fetching all Menus", a);
            }
           } catch (SQLException e) {
               throw new DAOException("Error fetching all Menus", e);
           }
    	
    	return menusByRestaurantId;
    }

    private Menu mapRow(ResultSet rs) throws SQLException {
        Menu menu = new Menu();
        menu.setMenuId(rs.getInt("MenuID"));
        menu.setRestaurantId(rs.getInt("RestaurantID"));
        menu.setItemName(rs.getString("ItemName"));
        menu.setDescription(rs.getString("Description"));
        menu.setPrice(rs.getBigDecimal("Price"));
        menu.setAvailable(rs.getBoolean("IsAvailable"));
        menu.setImagePath(rs.getString("ImagePath"));

        return menu;
    }
}
