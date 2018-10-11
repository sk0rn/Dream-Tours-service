package service.user.impl;

import pojo.Document;
import repository.iface.IDocumentDao;
import repository.impl.DocumentDao;
import service.user.iface.IDocumentSrv;

import java.util.List;

public class DocumentSrv implements IDocumentSrv {
    private IDocumentDao documentDao;

    public DocumentSrv() {
        this.documentDao = new DocumentDao();
    }

    public DocumentSrv(IDocumentDao documentDao) {
        this.documentDao = documentDao;
    }

    @Override
    public boolean add(Document document) {
        return documentDao.add(document);
    }

    @Override
    public List<Document> getAllByUserId(Integer userId) {
        return documentDao.getAllByUserId(userId);
    }

    @Override
    public boolean delete(Integer id) {
        return documentDao.delete(id);
    }
}
