package org.phoneBook.search;

import org.phoneBook.DAO.ContactsDAO;

public interface Search {
    void search (String searchContact, ContactsDAO contactsDAO);
}
