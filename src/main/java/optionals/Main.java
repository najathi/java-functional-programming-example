package optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.empty()
                .orElseGet(()-> "default value");
        System.out.println(value);

        Object value2 = Optional.of("Hello World!")
                .orElseGet(()-> "default value");
        System.out.println(value2);

        Optional.of("najathi@gmail.com")
                .ifPresent(email-> System.out.println("Sending email to " + email));

        Optional.empty()
                .ifPresentOrElse(
                        email-> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email!")
                );
    }
}
