package repository.impl;

import pojo.Document;
import repository.background.DaoBackground;
import repository.iface.IDocumentDao;

import java.util.List;

public class DocumentDao implements IDocumentDao {
    private final static DaoBackground<Document> background = new DaoBackground<>(Document::new,
            Document[]::new,
            Document::init);

    @Override
    public boolean add(Document document) {
        return background.execute("INSERT INTO document VALUES (Default, ?, ?, ?)",
                document.getClientId(), document.getFileName(), document.getDocType());
    }

    @Override
    public List<Document> getAllByUserId(Integer id) {
        return background.fetchRowsAsPojoList("SELECT * FROM document " +
                "WHERE client_id=?", id);
    }

    @Override
    public boolean delete(Integer id) {
        return background.execute("DELETE FROM document WHERE id = ?",
                id);
    }
}
