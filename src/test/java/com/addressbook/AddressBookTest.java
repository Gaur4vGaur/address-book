package com.addressbook;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressBookTest {

    private AddressBook addressBook;

    @Test
    public void countMaleTest() {
        addressBook = new AddressBook();
        assertEquals("count of males must be 3", 3, addressBook.countMales());
    }
}
