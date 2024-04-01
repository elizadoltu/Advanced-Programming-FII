package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class CarSharingApp {
    public static void main(String[] args) {
        List<Person> people = generateRandomGroup(10);

        LinkedList<Driver> sortedDrivers = getSortedDrivers(people);
        sortedDrivers.forEach(System.out::println);

        System.out.println("----------");

        Set<Passenger> sortedPassengers = getSortedPassengers(people);
        sortedPassengers.forEach(System.out::println);
    }

    private static List<Person> generateRandomGroup(int size) {
        Random random = new Random();
        String[] peopleNames = { "Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack" };

        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String name = peopleNames[random.nextInt(peopleNames.length)];
            int age = random.nextInt(60) + 20; // age between 20 and 79
            String destination = getRandomDestination();
            if (random.nextBoolean()) {
                persons.add(new Driver(name, age, destination));
            } else {
                persons.add(new Passenger(name, age, destination));
            }
        }
        return persons;
    }

    public static LinkedList<Driver> getSortedDrivers(List<Person> people) {
        return people.stream()
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .sorted(Comparator.comparingInt(Person::getAge))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public static Set<Passenger> getSortedPassengers(List<Person> people) {
        return people.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))));
    }

    private static String getRandomDestination() {
        String[] destinations = { "City A", "City B", "City C", "City D", "City E" };
        Random random = new Random();
        return destinations[random.nextInt(destinations.length)];
    }
}
