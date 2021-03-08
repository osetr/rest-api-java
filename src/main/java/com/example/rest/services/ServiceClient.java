package com.example.rest.services;

import com.example.rest.dao.ClientDAO;
import com.example.rest.entities.Client;


public class ServiceClient {
    public Client getClient (String email){
        ClientDAO daoClient = new ClientDAO();
        return daoClient.find(email);
    }
}
