package com.example.rest.servlets.Event;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.example.rest.dao.EventDAO;


@WebServlet(name = "EventDelete", value = "/event/delete")
public class EventDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(
                "<html>" +
                        "<form action='delete' method='post'>" +
                        "<p><input type='number' placeholder='event id' name='event_id'/></p>" +
                        "<button>Update</button>" +
                        "</form>" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("event_id"));
        EventDAO eventDAO = new EventDAO();
        eventDAO.delete(id);
        response.sendRedirect("/rest_war_exploded/event/get");
    }
}