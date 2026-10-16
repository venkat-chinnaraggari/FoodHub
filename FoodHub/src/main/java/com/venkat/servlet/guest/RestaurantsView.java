package com.venkat.servlet.guest;

import java.io.IOException;

import com.venkat.service.MenuService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import com.venkat.exception.DAOException;
import com.venkat.model.Menu;
import com.venkat.service.RestaurantService;
import com.venkat.model.Restaurant;

@WebServlet("/restaurants/view")
public class RestaurantsView extends HttpServlet
{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		MenuService menuService = new MenuService();
		RestaurantService restaurantService = new RestaurantService();
		
		int restaurantId = Integer.parseInt(req.getParameter("id"));
		
		try 
		{
			
			List<Menu> menuList = menuService.getMenusByRestaurantId(restaurantId);
			Restaurant restaurant = restaurantService.findById(restaurantId);
			
			req.setAttribute("menuItems", menuList);
			req.setAttribute("restaurant", restaurant);
			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/guest/restaurant-view.jsp");
			requestDispatcher.forward(req, resp);
			
		} catch (DAOException e) {
			resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error in Fetching Menus By Restaurant Id");;
		}
	}
}
