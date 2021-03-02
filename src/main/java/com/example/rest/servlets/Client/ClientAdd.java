package com.example.rest.servlets.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.example.rest.dao.ClientDAO;
import com.example.rest.entities.Client;

@WebServlet(name = "ClientAdd", value = "/client/add")
public class ClientAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(
                "<html>" +
                        "<form action='add' method='post'>" +
                        "<p><input type='text' placeholder='name' name='name'/></p>" +
                        "<p><input type='text' placeholder='email' name='email'/></p>" +
                        "<p><input type='text' placeholder='password' name='password'/></p>" +
                        "<p><input type='number' placeholder='age' name='age'/></p>" +
                        "<p><input type='number' placeholder='height' name='height'/></p>" +
                        "<p><input type='number' placeholder='weight' name='weight'/></p>" +
                        "<button>Save</button>" +
                        "</form>" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int age = Integer.parseInt(request.getParameter("age"));
        int height = Integer.parseInt(request.getParameter("height"));
        int weight = Integer.parseInt(request.getParameter("weight"));

        ClientDAO clientDAO = new ClientDAO();
        Client client = new Client();
        client.setName(name);
        client.setEmail(email);
        client.setPassword(password);
        client.setAge(age);
        client.setHeight(height);
        client.setWeight(weight);
        clientDAO.add(client);

        response.sendRedirect("/rest_war_exploded/client/add");
    }
}