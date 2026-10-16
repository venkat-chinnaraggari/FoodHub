package com.venkat.servlet.guest;

import java.io.IOException;

import java.util.List;
import com.venkat.dto.MenuRestaurantDAO;
import com.venkat.dto.MenuRestaurantDTO;
import com.venkat.exception.DAOException;
import com.venkat.model.Restaurant;
import com.venkat.service.RestaurantService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/homesearch")
public class HomeSearch extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String type = req.getParameter("type");
		String query = req.getParameter("query");
		
		if(query== null || query.isEmpty())
		{
			resp.sendRedirect(req.getContextPath() + "/home");
			return;
		}
		
		if(type.equals("dish"))
		{
			MenuRestaurantDAO menuRestaurantDAO = new MenuRestaurantDAO();
			List<MenuRestaurantDTO> menuItems = null;
			
			try {
				menuItems = menuRestaurantDAO.MenuItemsWithItemType(query);
			} catch (DAOException e) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "No Food Found with type " + query);
			}
			
			req.setAttribute("menuItems", menuItems);
			req.setAttribute("dish", query);
			req.setAttribute("type", type);
			req.getRequestDispatcher("/WEB-INF/views/guest/menuitems.jsp").forward(req, resp);
		}
		
		else if(type.equals("restaurant"))
		{
			RestaurantService restaurantService = new RestaurantService();
			List<Restaurant> restaurants = null;
			try {
				restaurants = restaurantService.getRestaurantsBySearch(query);
			} catch (DAOException e) {
				resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error Fetching Restaurants");
			}
			req.setAttribute("restaurants", restaurants);
			req.setAttribute("query", query);
			req.setAttribute("type", type);
			req.getRequestDispatcher("/WEB-INF/views/guest/restaurant-list.jsp").forward(req, resp);
		}
	}
}
