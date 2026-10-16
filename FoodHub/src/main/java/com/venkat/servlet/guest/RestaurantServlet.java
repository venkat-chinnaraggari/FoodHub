package com.venkat.servlet.guest;

import com.venkat.exception.DAOException;

import com.venkat.model.Restaurant;
import com.venkat.service.RestaurantService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/guest/restaurants")
public class RestaurantServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RestaurantService restaurantService = new RestaurantService();

        try {
            List<Restaurant> allRestaurants = restaurantService.findAll();
            req.setAttribute("restaurants", allRestaurants);
        } catch (DAOException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/guest/restaurant-list.jsp");
        requestDispatcher.forward(req, resp);

    }
}

