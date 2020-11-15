package org.phoneBook.menu;

import org.phoneBook.DAO.ContactName;
import org.phoneBook.DAO.ContactPhones;
import org.phoneBook.DAO.ContactsDAO;
import org.phoneBook.search.Search;
import org.phoneBook.search.SearchByName;
import org.phoneBook.search.SearchByPhone;

import java.util.Map;
import java.util.Scanner;

public class MenuRealization implements PhoneBookMenu {
    @Override
    public void showContacts(ContactsDAO contacts) {
        Map<ContactName, ContactPhones> show = contacts.getAll();
        for (ContactName contactName : show.keySet()) {
            System.out.println(contactName.toString());
            System.out.println(show.get(contactName).toString());
        }
    }

    @Override
    public void addNewContact(ContactsDAO contactsDAO, ContactName contactName, ContactPhones contactPhones) {
        contactsDAO.addContact(contactName, contactPhones);
    }

    @Override
    public void addNumber(String name, String number, ContactsDAO contactsDAO) {
        System.out.println("What kind of number you was entered?");
        System.out.println("1 - Fax"+"\n"+"2-Mobile"+"\n"+"3-Home");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1: contactsDAO.addFax(name, number); break;
            case 2: contactsDAO.addMobile(name, number); break;
            case 3: contactsDAO.addHome(name, number); break;
            default:
                System.out.println("Your choice is incorrect");
        }
    }

    @Override
    public void searchContact(ContactsDAO contactsDAO) {
        Search search;
        System.out.println("What kind of search you want?");
        System.out.println("1 - Search by name"+"\n"+"Else - Search by phone");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter your search query");
        String searchString = sc.nextLine();
        switch (choice){
            case 1: search = new SearchByName(); break;
            default: search = new SearchByPhone();
        }
        search.search(searchString,contactsDAO);
    }

    @Override
    public void deleteContactByName(ContactsDAO contactsDAO, String name) {
        contactsDAO.deleteContact(name);
    }

    @Override
    public void deleteNumberOfContact(ContactsDAO contactsDAO, String name) {
        System.out.println("What kind of number you want to delete?");
        System.out.println("1 - Fax"+"\n"+"2-Mobile"+"\n"+"3-Home");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the number");
        String number = sc.nextLine();
        switch (choice){
            case 1: contactsDAO.deleteFax(name, number); break;
            case 2: contactsDAO.deleteMobile(name, number); break;
            case 3: contactsDAO.deleteHome(name, number); break;
            default:
                System.out.println("Your choice is incorrect");
        }
    }
}
