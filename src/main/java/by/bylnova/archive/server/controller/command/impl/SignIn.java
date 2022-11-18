package by.bylnova.archive.server.controller.command.impl;

import by.bylnova.archive.server.controller.command.Command;
import by.bylnova.archive.server.service.UserService;
import by.bylnova.archive.server.service.exception.ServiceException;
import by.bylnova.archive.server.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute(String request) {
        String[] splitString = request.split(request);
        String login = splitString[1];
        String password = splitString[2];
        String response;
        // get parameters from request and initialize the variables login and password
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService clientService = serviceFactory.getUserService();
        try {
            clientService.signIn(login, password);
            response = "Welcome";
        } catch (ServiceException e) {
        // write log
            response = "Error during login procedure";
        }
        return response;
    }
}
