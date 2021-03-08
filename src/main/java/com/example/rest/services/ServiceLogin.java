package com.example.rest.services;

import com.example.rest.dao.ClientDAO;
import com.example.rest.entities.Client;

public class ServiceLogin {
    public Boolean login (String email, String password){
        ClientDAO daoClient = new ClientDAO();
        Client client = daoClient.find(email);

        if (client.getId() != 0) {
            return client.getPassword().equals(password);
        }
        return false;
    }
}
