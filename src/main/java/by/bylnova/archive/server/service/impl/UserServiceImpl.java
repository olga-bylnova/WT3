package by.bylnova.archive.server.service.impl;

import by.bylnova.archive.server.bean.User;
import by.bylnova.archive.server.dao.UserDAO;
import by.bylnova.archive.server.dao.exception.DAOException;
import by.bylnova.archive.server.dao.factory.DAOFactory;
import by.bylnova.archive.server.service.UserService;
import by.bylnova.archive.server.service.UserSession;
import by.bylnova.archive.server.service.exception.ServiceException;

public class UserServiceImpl implements UserService {
    private final DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private final UserDAO userDAO = daoObjectFactory.getUserDAO();
    private final UserSession userSession = UserSession.getInstance();

    @Override
    public boolean signIn(User user) throws ServiceException {
        if (user.getLogin() == null || user.getLogin().isEmpty()) {
            throw new ServiceException("Incorrect login");
        }
        try {
            if (userDAO.signIn(user)) {
                return userSession.addUser(user);
            }
            return false;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void signOut(User user) throws ServiceException {
        userSession.removeUser(user);
    }

    @Override
    public void registration(User user) throws ServiceException {
        try {
            userDAO.registration(user);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
