package com.example.rest.commands;
import com.example.rest.services.ServiceDish;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommandDish implements ICommand {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if ("GET".equals(request.getMethod())) {
            return "/dish.jsp";
        }

        ServiceDish serviceDish = new ServiceDish();
        Boolean res = serviceDish.validateAndSave(
                request.getParameter("name"),
                request.getParameter("fats"),
                request.getParameter("proteins"),
                request.getParameter("carbohydrates")
        );

        if (res) {
            return "home";
        }
        return "dish";
    }
}
