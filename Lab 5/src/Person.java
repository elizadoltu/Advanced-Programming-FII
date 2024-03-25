package person;

public record Person(String name, int id) {
}

/*
 * Echivalent la
 */

// public final class Person {
// private final String name;
// private final String id;

// public Person(String name, String id) {
// this.name = name;
// this.id = id;
// }

// String name() {
// return this.name;
// }

// String id() {
// return this.id;
// }

// public boolean equals() {
// }

// @Override
// public String toString() {
// return super.toString();
// }
// }
