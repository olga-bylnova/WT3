package by.bylnova.archive.server.service.impl;

import by.bylnova.archive.server.bean.Document;
import by.bylnova.archive.server.dao.DocumentDAO;
import by.bylnova.archive.server.dao.exception.DAOException;
import by.bylnova.archive.server.dao.factory.DAOFactory;
import by.bylnova.archive.server.service.ArchiveService;
import by.bylnova.archive.server.service.exception.ServiceException;

import java.util.List;

public class ArchiveServiceImpl implements ArchiveService {
    private final DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private final DocumentDAO documentDAO = daoObjectFactory.getDocumentDAO();
    @Override
    public void addNewDocument(Document document) throws ServiceException {
        if (document == null) {
            throw new ServiceException("Empty document");
        }
        try {
            documentDAO.addDocument(document);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteDocument(long id) throws ServiceException {
        try {
            documentDAO.deleteDocument(id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEditedDocument(Document document) throws ServiceException {

    }

    @Override
    public List<Document> listAllDocuments() throws ServiceException {
        try {
            return documentDAO.listDocuments();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
