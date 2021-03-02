package com.example.rest.entities;

public class Event {
    private int id;
    private int client;
    private int dish;

    public Event() {
    }

    public Event(int id, int client, int dish) {
        this.id = id;
        this.client = client;
        this.dish = dish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getDish() {
        return dish;
    }

    public void setDish(int dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", client=" + client +
                ", dish=" + dish +
                '}';
    }
}
