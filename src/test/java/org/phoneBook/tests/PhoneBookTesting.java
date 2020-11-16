package org.phoneBook.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.phoneBook.DAO.ContactName;
import org.phoneBook.DAO.ContactPhones;
import org.phoneBook.DAO.ContactsDAO;
import org.phoneBook.menu.PhoneBookMenu;

import java.util.List;
import java.util.Map;

public class PhoneBookTesting {
    @Mock
    private ContactsDAO contactsDAO;
    @Mock
    PhoneBookMenu phoneBookMenu;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        Mockito.when(contactsDAO.getAll())
                .thenReturn(Map.of(new ContactName("Sasha"),
                        new ContactPhones(
                                List.of("1234567890"),
                                List.of("+380000000000"),
                                List.of("0561111111")
                        )
                ));
    }

    @Test
    void TestingAddNewContact(){
        phoneBookMenu.addNewContact(contactsDAO,
                new ContactName("Tania"),
                new ContactPhones());
        Map<ContactName, ContactPhones> test = contactsDAO.getAll();
        Assert.assertTrue(test.containsKey(new ContactName("Tania")));
    }
}
