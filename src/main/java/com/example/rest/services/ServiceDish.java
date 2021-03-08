package com.example.rest.services;

import com.example.rest.dao.DishDAO;
import com.example.rest.entities.Dish;

public class ServiceDish {
    public Boolean validateAndSave (String name, String c, String f, String p){
        try {
            Dish dish = new Dish();
            dish.setName(name);
            dish.setProteins(Integer.parseInt(p));
            dish.setCarbohydrates(Integer.parseInt(c));
            dish.setFats(Integer.parseInt(f));
            DishDAO dishDAO = new DishDAO();
            dishDAO.add(dish);
            return true;
        } catch (Exception e) {
            System.out.println("Something went wrong.");
            return false;
        }
    }
}
