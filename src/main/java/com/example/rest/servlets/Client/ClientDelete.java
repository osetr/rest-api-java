package com.example.rest.servlets.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.example.rest.dao.ClientDAO;


@WebServlet(name = "ClientDelete", value = "/client/delete")
public class ClientDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(
                "<html>" +
                        "<form action='delete' method='post'>" +
                        "<p><input type='number' placeholder='client id' name='client_id'/></p>" +
                        "<button>Update</button>" +
                        "</form>" +
                        "</html>"
        );
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("client_id"));
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.delete(id);
        response.sendRedirect("/rest_war_exploded/client/get");
    }
}