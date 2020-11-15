package org.phoneBook.menu;

import org.phoneBook.DAO.ContactName;
import org.phoneBook.DAO.ContactPhones;
import org.phoneBook.DAO.ContactsDAO;

import java.util.Scanner;

public class StartMenu {
    private PhoneBookMenu phoneBookMenu;
    private ContactsDAO contactsDAO;
    private Scanner sc = new Scanner(System.in);

    public StartMenu(PhoneBookMenu phoneBookMenu, ContactsDAO contactsDAO) {
        this.phoneBookMenu = phoneBookMenu;
        this.contactsDAO = contactsDAO;
    }

    public void start(){
        boolean exit = false;
        while (true){
        System.out.println("_____________PHONE BOOK MENU_____________");
        System.out.println("1 - Show contacts"+"\n"
                            +"2 - Add new contact"+"\n"
                            +"3 - Add number to contact"+"\n"
                            +"4 - Search contact"+"\n"
                            +"5 - Delete contact by name"+"\n"
                            +"6 - Delete phone of contact"+"\n"
                            +"Else - Exit"+"\n"
                            +"Enter your choice");
        int choice = sc.nextInt();
        sc.nextLine();
        switch(choice){
            case 1: phoneBookMenu.showContacts(contactsDAO); break;
            case 2: addNewContact(); break;
            case 3: addNumberToContact(); break;
            case 4: phoneBookMenu.searchContact(contactsDAO); break;
            case 5: deleteContactByName(); break;
            case 6: deletePhoneOfContact(); break;
        }
        if(choice<1 || choice>6) break;
        }
    }

    private void addNewContact(){
        System.out.println("Enter the name:");
        ContactName contactName = new ContactName(sc.nextLine());
        boolean endProcess = false;
        ContactPhones contactPhones = new ContactPhones();
        while(true){
        System.out.println("What kind of number you want enter?");
        System.out.println("1 - Fax"+"\n"+"2-Mobile"+"\n"+"3-Home");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
            System.out.println("Enter the number:");
            String number = sc.nextLine();
        switch(choice) {
            case 1: contactPhones.addFax(number); break;
            case 2: contactPhones.addMobile(number); break;
            case 3: contactPhones.addHome(number); break;
        }
            System.out.println("Do you want to enter one more number?");
            System.out.println("1 - Yes"+"\n"+"Else - no");
            choice = sc.nextInt();
            sc.nextLine();
        if(choice != 1) break;
        }
        phoneBookMenu.addNewContact(contactsDAO, contactName, contactPhones);
    }

    private void addNumberToContact (){
        System.out.println("Enter the name of contact ");
        String name = sc.nextLine();
        System.out.println("Enter the number:");
        String number = sc.nextLine();
        phoneBookMenu.addNumber(name, number, contactsDAO);
    }

    private void deleteContactByName (){
        System.out.println("Enter the name of contact:");
        String name = sc.nextLine();
        phoneBookMenu.deleteContactByName(contactsDAO, name);
    }

    private void deletePhoneOfContact (){
        System.out.println("Enter the name of contact");
        String name = sc.nextLine();
        phoneBookMenu.deleteNumberOfContact(contactsDAO, name);
    }
}
