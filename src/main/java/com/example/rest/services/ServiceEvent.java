package com.example.rest.services;

import com.example.rest.dao.EventDAO;
import com.example.rest.entities.Dish;
import com.example.rest.entities.Event;
import java.util.List;

public class ServiceEvent {
    public List<Event> findAll() {
        EventDAO eventDAO = new EventDAO();
        return eventDAO.findAll();
    }

    public List<Dish> findCurrentDayDishes(int id) {
        EventDAO eventDAO = new EventDAO();
        return eventDAO.findCurrentDayDishes(id);
    }
}
