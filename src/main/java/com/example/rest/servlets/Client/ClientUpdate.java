package com.example.rest.servlets.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.example.rest.dao.ClientDAO;
import com.example.rest.entities.Client;

@WebServlet(name = "ClientUpdate", value = "/client/update")
public class ClientUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(
                "<html>" +
                        "<form action='update' method='post'>" +
                        "<p><input type='text' placeholder='new name' name='name'/></p>" +
                        "<p><input type='number' placeholder='client id' name='client_id'/></p>" +
                        "<button>Update</button>" +
                        "</form>" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String new_name = request.getParameter("name");
        int id = Integer.parseInt(request.getParameter("client_id"));
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.update(id, new_name);
        response.sendRedirect("/rest_war_exploded/client/get");
    }
}