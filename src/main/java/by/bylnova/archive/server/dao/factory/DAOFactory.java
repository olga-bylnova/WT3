package by.bylnova.archive.server.dao.factory;

import by.bylnova.archive.server.dao.DocumentDAO;
import by.bylnova.archive.server.dao.UserDAO;
import by.bylnova.archive.server.dao.impl.XmlDocumentDAO;
import by.bylnova.archive.server.dao.impl.XmlUserDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userDAOImpl = new XmlUserDAO();
    private final DocumentDAO documentDAOImpl = new XmlDocumentDAO();

    public static DAOFactory getInstance() {
        return instance;
    }

    private DAOFactory() {}

    public UserDAO getUserDAO() {
        return userDAOImpl;
    }

    public DocumentDAO getDocumentDAO() {
        return documentDAOImpl;
    }
}
