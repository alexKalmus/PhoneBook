package org.phoneBook.search;

import org.phoneBook.DAO.ContactName;
import org.phoneBook.DAO.ContactPhones;
import org.phoneBook.DAO.ContactsDAO;
import org.phoneBook.search.Search;

import java.util.List;
import java.util.Map;

public class SearchByPhone implements Search {
    @Override
    public void search(String searchPhone, ContactsDAO contactsDAO) {
        Map<ContactName, ContactPhones> contacts = contactsDAO.getAll();
        for (ContactName contactName : contacts.keySet()) {
            List<String> fax = contacts.get(contactName).getFaxPhones();
            printResult(contactName, fax, searchPhone);
            List<String> home = contacts.get(contactName).getHomePhones();
            printResult(contactName, home, searchPhone);
            List<String> mobile = contacts.get(contactName).getMobilePhones();
            printResult(contactName, mobile, searchPhone);
        }
    }

    private void printResult (ContactName contactName, List<String> phones, String searchPhone){
        boolean isResult = true;
        for (String phone : phones) {
            int index = phone.indexOf(searchPhone);
            if (index>=0)
                System.out.println(contactName.getName() + " " + phone);
            }
        }
}
