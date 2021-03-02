package com.example.rest.servlets.Event;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.example.rest.dao.EventDAO;
import com.example.rest.entities.Event;

@WebServlet(name = "EventAdd", value = "/event/add")
public class EventAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(
                "<html>" +
                        "<form action='add' method='post'>" +
                        "<p><input type='number' placeholder='client id' name='client_id'/></p>" +
                        "<p><input type='number' placeholder='dish id' name='dish_id'/></p>" +
                        "<button>Save</button>" +
                        "</form>" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dish_id = Integer.parseInt(request.getParameter("dish_id"));
        int client_id = Integer.parseInt(request.getParameter("client_id"));

        EventDAO eventDAO = new EventDAO();
        Event event = new Event();
        event.setClient(client_id);
        event.setDish(dish_id);
        eventDAO.add(event);

        response.sendRedirect("/rest_war_exploded/event/add");
    }
}