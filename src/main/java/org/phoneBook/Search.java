package org.phoneBook;

import org.phoneBook.DAO.ContactsDAO;

public interface Search {
    void search (String searchContact, ContactsDAO contactsDAO);
}
