package org.phoneBook.search;

import org.phoneBook.DAO.ContactName;
import org.phoneBook.DAO.ContactPhones;
import org.phoneBook.DAO.ContactsDAO;

import java.util.Map;

public class SearchByName implements Search {

    @Override
    public void search(String name, ContactsDAO contactsDAO) {
        Map<ContactName, ContactPhones> searchContacts = contactsDAO.getAll();
        char[] search = name.toCharArray();
        for (ContactName contactName : searchContacts.keySet()) {
            char[] searchName = contactName.getName().toCharArray();
            boolean isResult = true;
            for (int i = 0; i < search.length; i++) {
                if(search[i]!=searchName[i]) {
                    isResult = false;
                    break;
                }
            }
            if (isResult){
                System.out.println(contactName.toString());
                System.out.println(searchContacts.get(contactName).toString());
            }

        }
    }
}
