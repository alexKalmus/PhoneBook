package org.phoneBook.tests;

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

public class TestSearch {
    @Mock
    private ContactsDAO contactsDAO;
    @Mock
    PhoneBookMenu phoneBookMenu;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);

        Mockito.when(contactsDAO.getAll())
                .thenReturn(Map.of(new ContactName("Sasha"),
                        new ContactPhones(
                                List.of("1234567890"),
                                List.of("+380000000000"),
                                List.of("0561111111")),
                        new ContactName("Max"),
                        new ContactPhones(
                                List.of("1234509876"),
                                List.of("+3822222222222"),
                                List.of("0562222222"))
                ));
    }

    @Test
    void testSearchByName (){

    }
}
