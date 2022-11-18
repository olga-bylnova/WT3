package by.bylnova.archive.server.service.impl;

import by.bylnova.archive.server.bean.User;
import by.bylnova.archive.server.dao.UserDAO;
import by.bylnova.archive.server.dao.exception.DAOException;
import by.bylnova.archive.server.dao.factory.DAOFactory;
import by.bylnova.archive.server.service.UserService;
import by.bylnova.archive.server.service.exception.ServiceException;

public class UserServiceImpl implements UserService {

    @Override
    public void signIn(String login, String password) throws ServiceException {
        // реализуем функционал логинации пользователя в системе
        // проверяем параметры
        if (login == null || login.isEmpty()) {
            throw new ServiceException("Incorrect login");
        }
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        UserDAO userDAO = daoObjectFactory.getUserDAO();
        try {
            userDAO.signIn(login, password);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        //....
    }

    @Override
    public void signOut(String login) throws ServiceException {

    }

    @Override
    public void registration(User user) throws ServiceException {

    }
}
