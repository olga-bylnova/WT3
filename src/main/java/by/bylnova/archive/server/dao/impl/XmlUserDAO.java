package by.bylnova.archive.server.dao.impl;

import by.bylnova.archive.server.bean.User;
import by.bylnova.archive.server.bean.UserList;
import by.bylnova.archive.server.dao.UserDAO;
import by.bylnova.archive.server.dao.exception.DAOException;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class XmlUserDAO implements UserDAO {
    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;
    private final File file = new File("src/main/resources/users.xml");

    public XmlUserDAO() {
        try {
            JAXBContext context = JAXBContext.newInstance(UserList.class);
            JAXBContext unContext = JAXBContext.newInstance(UserList.class);

            marshaller = context.createMarshaller();
            unmarshaller = unContext.createUnmarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean signIn(String login, String password) throws DAOException {
        try {
            UserList users = getUserList();
            for (User user : users.getUsers()) {
                if (user.getLogin().equals(login) &&
                        user.getPassword().equals(password))
                    return true;
            }
        } catch (JAXBException e) {
            throw new DAOException(e);
        }
        return false;
    }

    @Override
    public void registration(User user) throws DAOException {
        try {
            UserList users = getUserList();
            if (checkUserExisting(users, user.getLogin())) {
                users.addUser(user);
                marshaller.marshal(users, file);
            } else {
                throw new DAOException("User with such login already exists");
            }
        } catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    private UserList getUserList() throws JAXBException {
        return (UserList) unmarshaller.unmarshal(file);
    }

    private boolean checkUserExisting(UserList users, String login) {
        return users.getUsers()
                .stream()
                .anyMatch(user -> user.getLogin().equals(login));
    }
}
