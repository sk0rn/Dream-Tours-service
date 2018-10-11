package service.iface;

import pojo.Contact;

import java.util.List;

public interface IContactSrv {

    boolean add(Contact contact);

    List<Contact> getAllByUserId(Integer userId);

    boolean updateById(Contact contact);

    boolean deleteById(Integer id);
}
