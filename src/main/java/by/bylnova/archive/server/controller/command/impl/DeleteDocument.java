package by.bylnova.archive.server.controller.command.impl;

import by.bylnova.archive.server.controller.command.Command;
import by.bylnova.archive.server.service.ArchiveService;
import by.bylnova.archive.server.service.UserService;
import by.bylnova.archive.server.service.exception.ServiceException;
import by.bylnova.archive.server.service.factory.ServiceFactory;

public class DeleteDocument implements Command {
    @Override
    public String execute(String request) {
        String[] splitString = request.split(" ");
        long id = Long.parseLong(splitString[1]);
        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ArchiveService archiveService = serviceFactory.getArchiveService();
        try {
            archiveService.deleteDocument(id);
            response = "deleted document";
        } catch (ServiceException e) {
            // write log
            response = "Error during delete document procedure";
        }
        return response;
    }
}
