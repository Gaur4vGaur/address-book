package com.addressbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
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

    public String oldestPerson() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        Comparator<String[]> byDate =
                (String[] array1, String[] array2) ->
                        LocalDate.parse(array1[DATE], formatter).isBefore(
                                LocalDate.parse(array1[DATE], formatter)) ? -1 : 1;

        String array[] = addressList.stream().min(byDate).get();

        return array[NAME];
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
