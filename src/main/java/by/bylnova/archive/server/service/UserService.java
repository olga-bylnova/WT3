package by.bylnova.archive.server.service;

import by.bylnova.archive.server.bean.User;
import by.bylnova.archive.server.service.exception.ServiceException;

public interface UserService {
    boolean signIn(User user) throws ServiceException;

    void signOut(User user) throws ServiceException;

    void registration(User user) throws ServiceException;
}
