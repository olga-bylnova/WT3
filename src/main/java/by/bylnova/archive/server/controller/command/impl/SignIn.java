package by.bylnova.archive.server.controller.command.impl;

import by.bylnova.archive.server.bean.User;
import by.bylnova.archive.server.controller.command.Command;
import by.bylnova.archive.server.service.UserService;
import by.bylnova.archive.server.service.exception.ServiceException;
import by.bylnova.archive.server.service.factory.ServiceFactory;

public class SignIn implements Command {
    @Override
    public String execute(String request) {
        String[] splitString = request.split(" ");
        String login = splitString[1];
        String password = splitString[2];
        String role = splitString[3];
        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService clientService = serviceFactory.getUserService();
        try {
            if (clientService.signIn(new User(login, password, role))) {
                response = "Welcome";
            } else {
                response = "Not registered";
            }
        } catch (ServiceException e) {
            response = "Error during login procedure";
        }
        return response;
    }
}
