package com.example.rest.servlets.Event;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import com.example.rest.dao.EventDAO;
import com.example.rest.entities.Event;

@WebServlet(name = "EventGet", value = "/event/get")
public class EventGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventDAO eventDAO = new EventDAO();
        List<Event> list = eventDAO.findAll();
        list.forEach((i) -> {
            try {
                response.getWriter().write("<p>" + String.valueOf(i) + "</p>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}