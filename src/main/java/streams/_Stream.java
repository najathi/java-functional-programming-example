package streams;

import static streams._Stream.Gender.*;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet()) // remove duplicates
                .forEach(System.out::println);

//        System.out.println();
//        people.stream()
//                .map(person -> person.name)
//                .mapToInt(String::length)
//                .forEach(System.out::println);

        System.out.println();
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        Predicate<Person> personPredicate1 = person -> FEMALE.equals(person.gender);

        boolean containsOnlyFemales = people.stream()
                .allMatch(personPredicate);
        System.out.println(containsOnlyFemales);
        boolean containsAlLeastFemales = people.stream()
                .anyMatch(personPredicate1);

        System.out.println(containsAlLeastFemales);

        boolean containsNotMatchFemales = people.stream()
                .noneMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsNotMatchFemales);

        System.out.println();
        people.stream()
                .filter(personPredicate1)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
