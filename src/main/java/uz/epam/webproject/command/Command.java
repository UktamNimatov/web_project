package uz.epam.webproject.command;

import javax.servlet.http.HttpServletRequest;

@FunctionalInterface
public interface Command {

    String execute(HttpServletRequest request);

    default void refresh(){};

}
