package uz.epam.webproject.command.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uz.epam.webproject.command.Command;
import uz.epam.webproject.service.UserService;
import uz.epam.webproject.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("username");
        logger.info(login);
        String email = request.getParameter("password");
        logger.info(email);
        UserService userService = UserServiceImpl.getInstance();
        if (userService.authenticate(login, email)) {
            request.setAttribute("user_name", login);
            return "pages/main.jsp";
        }else {
            request.setAttribute("login_message", "incorrect login or password");
            return "index.jsp";
        }
    }
}
