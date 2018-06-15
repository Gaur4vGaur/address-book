package com.addressbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBook {

    private String fileLocaltion = "AddressBook";
    List<String[]> addressList = new ArrayList<>();
    private int NAME = 0;
    private int GENDER = 1;
    private int DATE = 2;

    public AddressBook() {
        readFile();
    }

    public long countMales() {
        return addressList.stream().filter(input -> input[GENDER].equals("Male")).count();
    }

    private void readFile() {
        try (Stream<String> stream = Files.lines(Paths.get(fileLocaltion))) {
            addressList = stream.
                    map(input -> input.split(", ")).
                    collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Error fetching file");
            e.printStackTrace();
        }
    }
}
