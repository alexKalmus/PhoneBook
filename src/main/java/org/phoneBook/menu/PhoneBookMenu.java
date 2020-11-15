package org.phoneBook.menu;

import org.phoneBook.DAO.ContactName;
import org.phoneBook.DAO.ContactPhones;
import org.phoneBook.DAO.ContactsDAO;

public interface PhoneBookMenu {
    void showContacts (ContactsDAO contacts);
    void addNewContact (ContactsDAO contactsDAO, ContactName contactName, ContactPhones contactPhones);
    void addNumber (String name, String number, ContactsDAO contactsDAO);
    void searchContact(ContactsDAO contactsDAO);
    void deleteContactByName(ContactsDAO contactsDAO, String name);
    void deleteNumberOfContact (ContactsDAO contactsDAO, String name);
}
