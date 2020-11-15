package org.phoneBook.DAO;

import java.util.Map;

public interface ContactsDAO {
    Map<ContactName, ContactPhones> getAll();
    void addContact(ContactName name, ContactPhones phones);
    void addFax(String name, String number);
    void addMobile(String name, String number);
    void addHome(String name, String number);
    void deleteContact (String name);
    void deleteFax (String name, String number);
    void deleteMobile (String name, String number);
    void deleteHome (String name, String number);
}
