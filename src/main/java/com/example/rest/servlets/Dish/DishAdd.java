package com.example.rest.servlets.Dish;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.example.rest.dao.DishDAO;
import com.example.rest.entities.Dish;

@WebServlet(name = "DishAdd", value = "/dish/add")
public class DishAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(
                "<html>" +
                        "<form action='add' method='post'>" +
                        "<p><input type='text' placeholder='name' name='name'/></p>" +
                        "<p><input type='number' placeholder='proteins' name='proteins'/></p>" +
                        "<p><input type='number' placeholder='fats' name='fats'/></p>" +
                        "<p><input type='number' placeholder='carbohydrates' name='carbohydrates'/></p>" +
                        "<button>Save</button>" +
                        "</form>" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int proteins = Integer.parseInt(request.getParameter("proteins"));
        int fats = Integer.parseInt(request.getParameter("fats"));
        int carbohydrates = Integer.parseInt(request.getParameter("carbohydrates"));

        DishDAO dishDAO = new DishDAO();
        Dish dish = new Dish();
        dish.setName(name);
        dish.setProteins(proteins);
        dish.setFats(fats);
        dish.setCarbohydrates(carbohydrates);
        dishDAO.add(dish);

        response.sendRedirect("/rest_war_exploded/dish/add");
    }
}