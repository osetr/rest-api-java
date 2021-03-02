package com.example.rest.idao;

import com.example.rest.entities.Dish;

import java.util.List;

public interface DishDAO {
    void add(Dish dish);
    void update(int id, String newName);
    void delete(int id);
    List<Dish> findAll();
}
