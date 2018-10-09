package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class Tour implements Initiable {
    private Integer id;
    private String albumGuid;
    private String youtubeUrl;
    private String desc;

    public Tour() {
    }

    public Tour(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 4) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.id = (Integer) fields[0];
        this.albumGuid = (String) fields[1];
        this.youtubeUrl = (String) fields[2];
        this.desc = (String) fields[3];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlbumGuid() {
        return albumGuid;
    }

    public void setAlbumGuid(String albumGuid) {
        this.albumGuid = albumGuid;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", albumGuid='" + albumGuid + '\'' +
                ", youtubeUrl='" + youtubeUrl + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
