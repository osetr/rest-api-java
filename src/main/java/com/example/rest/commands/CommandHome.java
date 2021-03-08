package com.example.rest.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandHome implements ICommand{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "/home.jsp";
    }
}