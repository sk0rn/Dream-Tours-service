package service.impl;

import pojo.Contact;
import repository.iface.IContactDao;
import repository.impl.ContactDao;
import service.iface.IContactSrv;

import java.util.List;

public class ContactSrv implements IContactSrv {
    private IContactDao contactDao;

    public ContactSrv() {
        this.contactDao = new ContactDao();
    }

    public ContactSrv(IContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public boolean add(Contact contact) {
        return contactDao.add(contact);
    }

    @Override
    public List<Contact> getAllByUserId(Integer userId) {
        return contactDao.getAllByUserId(userId);
    }

    @Override
    public boolean updateById(Contact contact) {
        return contactDao.updateById(contact);
    }

    @Override
    public boolean deleteById(Integer id) {
        return contactDao.deleteById(id);
    }
}
