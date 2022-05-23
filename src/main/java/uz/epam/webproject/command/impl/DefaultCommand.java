package uz.epam.webproject.command.impl;

import uz.epam.webproject.command.Command;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "index.jsp";
    }
}
