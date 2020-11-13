package org.phoneBook;


import org.phoneBook.DAO.ContactsDAO;
import org.phoneBook.DAO.InArrayContacts;

public class Main {
    public static void main(String[] args) {
        ContactsDAO contactsDAO = new InArrayContacts();
        PhoneBookMenu phoneBookMenu = new MenuRealization();
        StartMenu startMenu = new StartMenu(phoneBookMenu, contactsDAO);
        startMenu.start();
    }
}
