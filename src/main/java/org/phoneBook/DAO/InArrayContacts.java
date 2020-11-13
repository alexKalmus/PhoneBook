package org.phoneBook.DAO;

import org.phoneBook.ContactName;
import org.phoneBook.ContactPhones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InArrayContacts implements ContactsDAO{
    Map<ContactName, ContactPhones> contacts = new HashMap<>();

    public InArrayContacts() {
        List<String> fax = new ArrayList<>();
        fax.add("1857482584");
        fax.add("1256492353");
        List<String> home = new ArrayList<>();
        home.add("+380562378954");
        List<String> mobile = new ArrayList<>();
        mobile.add("+380503611120");
        contacts.put(new ContactName("Sasha"), new ContactPhones(fax, home, mobile));
        List<String> faxTanya = new ArrayList<>();
        faxTanya.add("1549856248");
        List<String> homeTanya = new ArrayList<>();
        homeTanya.add("+380562205743");
        List<String> mobileTanya = new ArrayList<>();
        mobileTanya.add("+380504813556");
        contacts.put(new ContactName("Tatyana"), new ContactPhones(faxTanya, homeTanya, mobileTanya));

    }

    @Override
    public Map<ContactName, ContactPhones> getAll() {
        return contacts;
    }

    @Override
    public void addContact(ContactName name, ContactPhones phones) {
        if (!contacts.containsKey(name)) contacts.put(name, phones);
    }

    @Override
    public void addFax(String name, String number) {
        contacts.get(new ContactName(name)).addFax(number);
    }

    @Override
    public void addMobile(String name, String number) {
        contacts.get(new ContactName(name)).addMobile(number);
    }

    @Override
    public void addHome(String name, String number) {
        contacts.get(new ContactName(name)).addHome(number);
    }

    @Override
    public void deleteContact(String name) {
        contacts.remove(new ContactName(name));
    }

    @Override
    public void deleteFax(String name, String number) {
        contacts.get(new ContactName(name)).deleteFax(number);
        if(contacts.get(new ContactName(name)).isEmpty())
            contacts.remove(new ContactName(name));
    }

    @Override
    public void deleteMobile(String name, String number) {
        contacts.get(new ContactName(name)).deleteMobile(number);
        if(contacts.get(new ContactName(name)).isEmpty())
            contacts.remove(new ContactName(name));
    }

    @Override
    public void deleteHome(String name, String number) {
        contacts.get(new ContactName(name)).deleteHome(number);
        if(contacts.get(new ContactName(name)).isEmpty())
            contacts.remove(new ContactName(name));
    }

}
