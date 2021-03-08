package com.example.rest.commands;

import com.example.rest.entities.Client;
import com.example.rest.services.ServiceClient;
import com.example.rest.services.ServiceLogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommandLogin implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("client"));

        if ("GET".equals(request.getMethod())) {
            return "/login.jsp";
        }

        String path;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        ServiceLogin serviceLogin = new ServiceLogin();
        ServiceClient serviceClient = new ServiceClient();
        Boolean statusLogin = serviceLogin.login(email, password);

        if ( statusLogin ){
            Client client = serviceClient.getClient(email);
            session.setAttribute("client", client.getId());
            path = "/home";
        } else {
            Client client = serviceClient.getClient(email);
            path = "/login";
        }

        return path;
    }
}
