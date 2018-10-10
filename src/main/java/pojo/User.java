package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

import java.sql.Timestamp;

public class User implements Initiable {
    private Integer id;
    private String login;
    private String password;
    private Integer option;
    private String fio;
    private java.sql.Timestamp callTime;
    private Boolean subscribe;
    private Double bonus;
    private String albumGuid;

    public User() {
    }

    public User(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 9) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.id = (Integer) fields[0];
        this.login = (String) fields[1];
        this.password = (String) fields[2];
        this.option = (Integer) fields[3];
        this.fio = (String) fields[4];
        this.callTime = (Timestamp) fields[5];
        this.subscribe = (Boolean) fields[6];
        this.bonus = (Double) fields[7];
        this.albumGuid = (String) fields[8];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getOption() {
        return option;
    }

    public void setOption(Integer option) {
        this.option = option;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public java.sql.Timestamp getCallTime() {
        return callTime;
    }

    public void setCallTime(java.sql.Timestamp callTime) {
        this.callTime = callTime;
    }

    public Boolean getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(Boolean subscribe) {
        this.subscribe = subscribe;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public String getAlbumGuid() {
        return albumGuid;
    }

    public void setAlbumGuid(String albumGuid) {
        this.albumGuid = albumGuid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", option=" + option +
                ", fio='" + fio + '\'' +
                ", callTime=" + callTime +
                ", subscribe='" + subscribe + '\'' +
                ", bonus=" + bonus +
                ", albumGuid='" + albumGuid + '\'' +
                '}';
    }
}
