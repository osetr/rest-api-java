package com.example.rest.servlets;

import com.example.rest.helpers.CommandHelper;
import com.example.rest.commands.ICommand;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "controllerServlet", value = "/login")
public class ControllerLogin extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ICommand command = CommandHelper.getCommand("login");
        String path = command.execute(request, response);
        response.sendRedirect(path);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ICommand command = CommandHelper.getCommand("login");
        String path = command.execute(request, response);
        request.getRequestDispatcher(path).forward(request, response);
    }
}
