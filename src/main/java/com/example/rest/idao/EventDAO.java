package com.example.rest.idao;

import com.example.rest.entities.Event;

import java.util.List;

public interface EventDAO {
    void add(Event event);
    void delete(int id);
    List<Event> findAll();
}
