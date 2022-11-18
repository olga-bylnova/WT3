package by.bylnova.archive.server.dao;

import by.bylnova.archive.server.bean.Document;
import by.bylnova.archive.server.dao.exception.DAOException;

import java.util.List;

public interface DocumentDAO {
    void addDocument(Document document) throws DAOException;
    void deleteDocument(long idDocument) throws DAOException;
    void editDocument(long idDocument) throws DAOException;
    List<Document> listDocuments() throws DAOException;
}
