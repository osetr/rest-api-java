package com.example.rest.servlets.Dish;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import com.example.rest.dao.DishDAO;
import com.example.rest.entities.Dish;

@WebServlet(name = "DishGet", value = "/dish/get")
public class DishGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DishDAO dishDAO = new DishDAO();
        List<Dish> list = dishDAO.findAll();
        list.forEach((i) -> {
            try {
                response.getWriter().write("<p>" + String.valueOf(i) + "</p>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}