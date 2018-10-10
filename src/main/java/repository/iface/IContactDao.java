package repository.iface;

import pojo.Contact;

import java.util.List;

public interface IContactDao {

    boolean add(Contact contact);

    List<Contact> getAllByUserId(Integer userId);

    boolean updateById(Contact contact);

    boolean deleteById(Integer id);
}
