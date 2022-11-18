package by.bylnova.archive.server.service;

import by.bylnova.archive.server.bean.User;
import by.bylnova.archive.server.service.exception.ServiceException;

public interface UserService {
    boolean signIn(String login, String password) throws ServiceException;

    void signOut(String login) throws ServiceException;

    void registration(User user) throws ServiceException;
}
