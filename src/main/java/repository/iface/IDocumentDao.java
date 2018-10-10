package repository.iface;

import pojo.Document;

import java.util.List;

public interface IDocumentDao {

    boolean add(Document document);

    List<Document> getAllByUserId(Integer id);

    boolean delete(Integer id);
}
