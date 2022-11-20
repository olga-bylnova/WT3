package by.bylnova.archive.server.service;

import by.bylnova.archive.server.bean.User;

public final class UserSession {
    private User activeUser;
    private static final UserSession instance = new UserSession();

    public static UserSession getInstance() {
        return instance;
    }

    public boolean addUser(User user) {
        if (!isUserActive()) {
            activeUser = user;
            return true;
        }
        return false;
    }

    public void removeUser(User user) {
        activeUser = null;
    }

    public boolean isUserActive() {
        return activeUser != null;
    }

    public User getActiveUser() {
        return activeUser;
    }
}
