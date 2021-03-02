package com.example.rest.servlets.Dish;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.example.rest.dao.DishDAO;


@WebServlet(name = "DishDelete", value = "/dish/delete")
public class DishDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(
                "<html>" +
                        "<form action='delete' method='post'>" +
                        "<p><input type='number' placeholder='dish id' name='dish_id'/></p>" +
                        "<button>Update</button>" +
                        "</form>" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("dish_id"));
        DishDAO dishDAO = new DishDAO();
        dishDAO.delete(id);
        response.sendRedirect("/rest_war_exploded/dish/get");
    }
}