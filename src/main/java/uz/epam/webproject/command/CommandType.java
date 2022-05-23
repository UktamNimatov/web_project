package uz.epam.webproject.command;

import uz.epam.webproject.command.impl.AddUserCommand;
import uz.epam.webproject.command.impl.DefaultCommand;
import uz.epam.webproject.command.impl.LoginCommand;
import uz.epam.webproject.command.impl.LogoutCommand;

public enum CommandType {
    ADD_USER(new AddUserCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    DEFAULT(new DefaultCommand());

    Command command;
    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public static Command define(String commandStr){
//        if (commandStr == null) return new DefaultCommand();
        CommandType current;
//        try {
             current = CommandType.valueOf(commandStr.toUpperCase());
//        }catch (IllegalArgumentException exception){
//            return new DefaultCommand();
//        }
        return current.command;
    }
}
