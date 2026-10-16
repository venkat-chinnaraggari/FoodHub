package com.venkat.servlet.guest;

import java.util.List;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.venkat.exception.DAOException;
import com.venkat.model.Restaurant;
import com.venkat.service.RestaurantService;


@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RestaurantService restaurantService = new RestaurantService();
		
		try 
		{
			List<Restaurant> popularRestaurants = restaurantService.popularRestaurants();
			request.setAttribute("popularRestaurants", popularRestaurants);
			
		} catch (DAOException e) 
		{
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error in Fetching Popular Restaurants");
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/guest/homepage.jsp");
		requestDispatcher.forward(request, response);
	}

}
