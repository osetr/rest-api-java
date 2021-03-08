package com.example.rest.helpers;

import com.example.rest.commands.*;

import java.util.HashMap;

public class CommandHelper {
    private static HashMap<String, ICommand> commands = null;
    static {
        commands = new HashMap<>();
        commands.put("login", new CommandLogin());
        commands.put("home", new CommandHome());
        commands.put("signup", new CommandSignup());
        commands.put("dish", new CommandDish());
    }

    private CommandHelper(){
    }

    public static ICommand getCommand(String key){
        return commands.get(key);
    }
}
