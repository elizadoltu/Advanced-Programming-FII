package com.example;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        List<Person> people = generateRandomGroup(10);
        ProblemSolver.solve(people);
    }

    private static List<Person> generateRandomGroup(int size) {
        List<Person> persons = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < size; i++) {
            String name = faker.name().fullName();
            int age = faker.number().numberBetween(20, 80);
            String destination = getRandomDestination();
            if (faker.random().nextBoolean()) {
                persons.add(new Driver(name, age, destination));
            } else {
                persons.add(new Passenger(name, age, destination));
            }
        }
        return persons;
    }

    private static String getRandomDestination() {
        String[] destinations = { "City A", "City B", "City C", "City D", "City E" };
        int index = new Faker().random().nextInt(destinations.length);
        return destinations[index];
    }
}
