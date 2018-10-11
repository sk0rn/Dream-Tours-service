package service.user.iface;

import pojo.Document;

import java.util.List;

public interface IDocumentSrv {

    boolean add(Document document);

    List<Document> getAllByUserId(Integer userId);

    boolean delete(Integer id);
}
