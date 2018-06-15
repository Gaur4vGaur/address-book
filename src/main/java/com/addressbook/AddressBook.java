package com.addressbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AddressBook {

    private String fileLocaltion = "AddressBook";

    public int countMales() {
        int count = 0;
        try (Stream<String> stream = Files.lines(Paths.get(fileLocaltion))) {
            count = stream.filter(input -> input.contains("Male")).
                    map(i -> 1).
                    collect(Collectors.toList()).size();
        } catch (IOException e) {
            System.out.println("Error fetching file");
            e.printStackTrace();
        }

        return count;
    }
}
