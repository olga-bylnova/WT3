package by.bylnova.archive.server.service.factory;

import by.bylnova.archive.server.service.ArchiveService;
import by.bylnova.archive.server.service.UserService;
import by.bylnova.archive.server.service.impl.ArchiveServiceImpl;
import by.bylnova.archive.server.service.impl.UserServiceImpl;

public class ServiceFactory {
    private final static ServiceFactory instance = new ServiceFactory();
    private final UserService userServiceImpl = new UserServiceImpl();
    private final ArchiveService archiveServiceImpl = new ArchiveServiceImpl();

    private ServiceFactory() {}

    public UserService getUserService() {
        return userServiceImpl;
    }

    public ArchiveService getArchiveService() {
        return archiveServiceImpl;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
