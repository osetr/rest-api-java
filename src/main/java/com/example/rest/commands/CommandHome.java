package com.example.rest.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.rest.dao.EventDAO;
import com.example.rest.entities.Dish;
import com.example.rest.entities.Event;
import com.example.rest.services.ServiceDish;
import com.example.rest.services.ServiceEvent;
import java.io.IOException;
import java.util.List;

public class CommandHome implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("client") == null) {
            return "/login";
        }

        if ("GET".equals(request.getMethod())) {
            ServiceDish serviceDish = new ServiceDish();
            List<Dish> dishes = serviceDish.findAll();
            request.setAttribute("dishes", dishes);

            ServiceEvent serviceEvent = new ServiceEvent();
            List<Dish> events = serviceEvent.findCurrentDayDishes(Integer.parseInt(session.getAttribute("client").toString()));
            request.setAttribute("events", events);

            int fats = 0;
            int proteins = 0;
            int carbohydrates = 0;

            for (Dish dish : events) {
                fats += dish.getFats();
                proteins += dish.getProteins();
                carbohydrates += dish.getCarbohydrates();
            }

            System.out.println(fats);
            System.out.println(proteins);
            System.out.println(carbohydrates);

            if (fats > 300 | proteins > 500 | carbohydrates > 1000) {
                request.setAttribute("message", "limit reached");
            } else {
                request.setAttribute("message", "");
            }

            return "/home.jsp";
        }

        int id = Integer.parseInt(request.getParameter("dishes"));
        int client_id = Integer.parseInt(session.getAttribute("client").toString());
        Event event = new Event();
        event.setDish(id);
        event.setClient(client_id);
        EventDAO eventDAO = new EventDAO();
        eventDAO.add(event);

        return "/home";
    }
}