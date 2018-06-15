package com.addressbook;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddressBookTest {

    private AddressBook addressBook;

    @Test
    public void countMaleTest() {
        addressBook = new AddressBook();
        assertEquals("count of males must be 3", 3, addressBook.countMales());
    }

    @Test
    public void readFileTest() {
        addressBook = new AddressBook();
        assertTrue("must have read the file while instantiating the class", addressBook.addressList.size() > 0);
    }

    @Test
    public void oldestPersonTest() {
        addressBook = new AddressBook();
        assertEquals("oldest person must be Wes Jackson", "Wes Jackson", addressBook.oldestPerson());
    }

    @Test
    public void ageDifferenceTest() {
        addressBook = new AddressBook();
        assertEquals("age difference between Paul and Bill is not correct", 2862, addressBook.ageDifference());
    }
}
