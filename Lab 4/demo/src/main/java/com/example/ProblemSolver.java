package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class ProblemSolver {

    public static void solve(List<Person> people) {
        LinkedList<Driver> sortedDrivers = getSortedDrivers(people);
        sortedDrivers.forEach(System.out::println);

        System.out.println("----------");

        Set<Passenger> sortedPassengers = getSortedPassengers(people);
        sortedPassengers.forEach(System.out::println);

        System.out.println("----------");

        Map<String, List<Passenger>> destinationPassengerMap = getDestinationPassengerMap(people);
        destinationPassengerMap.forEach((destination, passengers) -> {
            System.out.println(destination + ": " + passengers);
        });

        System.out.println("----------");

        List<String> driverDestinations = getDriverDestinations(people);
        System.out.println("Destinations of drivers: " + driverDestinations);

        System.out.println("----------");

        List<Match> matches = greedyMatch(people);
        System.out.println("Greedy matches:");
        matches.forEach(System.out::println);
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

    public static Map<String, List<Passenger>> getDestinationPassengerMap(List<Person> people) {
        return people.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .collect(Collectors.groupingBy(Person::getDestination));
    }

    public static List<String> getDriverDestinations(List<Person> people) {
        return people.stream()
                .filter(person -> person instanceof Driver)
                .map(Person::getDestination)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Match> greedyMatch(List<Person> people) {
        List<Match> matches = new ArrayList<>();
        Map<String, List<Passenger>> destinationPassengerMap = getDestinationPassengerMap(people);
        LinkedList<Driver> drivers = getSortedDrivers(people);

        for (Driver driver : drivers) {
            String destination = driver.getDestination();
            List<Passenger> passengers = destinationPassengerMap.getOrDefault(destination, new ArrayList<>());
            if (!passengers.isEmpty()) {
                Passenger passenger = passengers.get(0); // Choose the first passenger
                matches.add(new Match(driver, passenger));
                passengers.remove(passenger); // Remove matched passenger
                destinationPassengerMap.put(destination, passengers); // Update destination passenger list
            }
        }

        return matches;
    }

}
