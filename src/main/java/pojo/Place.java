package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class Place implements Initiable {
  private Integer id;
  private String name;
  private String desc;

  public Place() {
  }

  public Place(Object... fields) {
    init(fields);
  }

  @Override
  public void init(Object... fields) {
    if (fields == null || fields.length != 3) {
      throw new InvalidNumberOfArgumentsException();
    }
    this.id = (Integer) fields[0];
    this.name = (String) fields[1];
    this.desc = (String) fields[2];
  }
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  @Override
  public String toString() {
    return "Place{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", desc='" + desc + '\'' +
            '}';
  }
}
