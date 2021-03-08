package com.example.rest.servlets;

import com.example.rest.commands.ICommand;
import com.example.rest.helpers.CommandHelper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletDish", value = "/dish")
public class ControllerDish extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ICommand command = CommandHelper.getCommand("dish");
        String path = command.execute(request, response);
        response.sendRedirect(path);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ICommand command = CommandHelper.getCommand("dish");
        String path = command.execute(request, response);
        request.getRequestDispatcher(path).forward(request, response);
    }
}
