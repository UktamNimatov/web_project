package uz.epam.webproject.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uz.epam.webproject.command.Command;
import uz.epam.webproject.command.CommandType;
import uz.epam.webproject.command.impl.LoginCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = {"/controller", "*.do"})
public class Controller extends HttpServlet {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void init() throws ServletException {

    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String strCommand = req.getParameter("command");
        logger.info(strCommand);
        Command command = CommandType.define(strCommand);
        String page = command.execute(req);
        logger.info(page);
        req.getRequestDispatcher(page).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void destroy() {
    }
}
