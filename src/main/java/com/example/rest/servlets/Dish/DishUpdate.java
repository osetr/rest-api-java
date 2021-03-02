package com.example.rest.servlets.Dish;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.example.rest.dao.DishDAO;
import com.example.rest.entities.Dish;

@WebServlet(name = "DishUpdate", value = "/dish/update")
public class DishUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(
                "<html>" +
                        "<form action='update' method='post'>" +
                        "<p><input type='text' placeholder='new name' name='name'/></p>" +
                        "<p><input type='number' placeholder='dish id' name='dish_id'/></p>" +
                        "<button>Update</button>" +
                        "</form>" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String new_name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("dish_id"));
        DishDAO dishDAO = new DishDAO();
        dishDAO.update(id, new_name);
        response.sendRedirect("/rest_war_exploded/dish/get");
    }
}