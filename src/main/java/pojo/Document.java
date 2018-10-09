package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class Document implements Initiable {
    private Integer id;
    private Integer clientId;
    private String fileName;
    private String docType;

    public Document() {
    }

    public Document(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 4) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.id = (Integer) fields[0];
        this.clientId = (Integer) fields[1];
        this.fileName = (String) fields[2];
        this.docType= (String) fields[3];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", fileName='" + fileName + '\'' +
                ", docType='" + docType + '\'' +
                '}';
    }
}
