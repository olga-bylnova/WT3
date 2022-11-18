package by.bylnova.archive.server.controller.command.impl;

import by.bylnova.archive.server.bean.Document;
import by.bylnova.archive.server.controller.command.Command;
import by.bylnova.archive.server.service.ArchiveService;
import by.bylnova.archive.server.service.exception.ServiceException;
import by.bylnova.archive.server.service.factory.ServiceFactory;

public class AddDocument implements Command {
    @Override
    public String execute(String request) {
        String[] splitString = request.split(request);
        long id = Long.parseLong(splitString[1]);
        String name = splitString[2];
        String response;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ArchiveService archiveService = serviceFactory.getArchiveService();
        try {
            archiveService.addNewDocument(new Document(name, id));
            response = "added document";
        } catch (ServiceException e) {
            // write log
            response = "Error during add document procedure";
        }
        return response;
    }
}
