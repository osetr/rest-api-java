package com.example.rest.servlets.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import com.example.rest.dao.ClientDAO;
import com.example.rest.entities.Client;

@WebServlet(name = "ClientGet", value = "/client/get")
public class ClientGet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientDAO clientDAO = new ClientDAO();
        List<Client> list = clientDAO.findAll();
        list.forEach((i) -> {
            try {
                response.getWriter().write("<p>" + String.valueOf(i) + "</p>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}