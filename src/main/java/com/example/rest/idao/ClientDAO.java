package com.example.rest.idao;

import com.example.rest.entities.Client;

import java.util.List;

public interface ClientDAO {
    void add(Client client);
    void update(int id, String newName);
    void delete(int id);
    List<Client> findAll();
}
