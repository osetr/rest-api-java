package com.example.rest.commands;

import com.example.rest.dao.ClientDAO;
import com.example.rest.entities.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandSignup implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("client"));

        if ("GET".equals(request.getMethod())) {
            return "/signup.jsp";
        }

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        int height = Integer.parseInt(request.getParameter("height"));
        int weight = Integer.parseInt(request.getParameter("weight"));

        Client client = new Client();
        client.setName(name);
        client.setEmail(email);
        client.setPassword(password);
        client.setAge(age);
        client.setHeight(height);
        client.setWeight(weight);
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.add(client);

        return "login";
    }
}