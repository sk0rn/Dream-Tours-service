package repository.impl;

import pojo.Contact;
import repository.background.DaoBackground;
import repository.iface.IContactDao;

import java.util.Arrays;
import java.util.List;

public class ContactDao implements IContactDao {
    private final static DaoBackground<Contact> background = new DaoBackground<>(Contact::new,
            Contact[]::new,
            Contact::init);

    @Override
    public boolean add(Contact contact) {
        return background.execute("INSERT INTO contact VALUES (Default, ?, ?)",
                contact.getClientId(), contact.getValue());
    }

    @Override
    public List<Contact> getAllByUserId(Integer id) {
        return background.fetchRowsAsPojoList("SELECT * FROM contact " +
                "WHERE client_id=?", id);
    }

    @Override
    public boolean updateById(Contact contact) {
        return background.execute("Update contact SET value=? where id=?",
                contact.getValue(), contact.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return background.execute("DELETE FROM contact WHERE id = ?",
                id);
    }
}
