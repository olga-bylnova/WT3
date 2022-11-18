package by.bylnova.archive.server.dao;

import by.bylnova.archive.server.bean.User;
import by.bylnova.archive.server.dao.exception.DAOException;

public interface UserDAO {
    boolean signIn(String login, String password) throws DAOException;
    void registration(User user) throws DAOException;
}
