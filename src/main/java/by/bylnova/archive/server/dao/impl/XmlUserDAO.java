package by.bylnova.archive.server.dao.impl;

import by.bylnova.archive.server.bean.User;
import by.bylnova.archive.server.dao.UserDAO;
import by.bylnova.archive.server.dao.exception.DAOException;
import by.bylnova.archive.server.service.exception.ServiceException;

public class XmlUserDAO implements UserDAO {
    @Override
    public void signIn(String login, String password) throws DAOException {
        //TODO check login&password
    }

    @Override
    public void registration(User user) throws DAOException {

    }
}
