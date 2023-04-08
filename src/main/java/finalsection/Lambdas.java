package finalsection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {
        Function<String, String> upperCaseText = String::toUpperCase;
        Function<String, String> upperCaseText2 = name -> {
            //login

            if (name.isBlank()) throw new IllegalArgumentException("name is undefined");
            return name.toUpperCase();
        };

        System.out.println(upperCaseText.apply("najathi"));
        System.out.println(upperCaseText2.apply("najathi"));
        System.out.println(upperCaseText3.apply("najathi", 20));
    }

    // primitive datatype, cannot allow to use it here like int, float, boolean, string.
    // otherwise you can use Boolean, Integer, String
    static BiFunction<String,Integer, String> upperCaseText3 = (name, age) -> {
        //login

        if (name.isBlank()) throw new IllegalArgumentException("name is undefined");
        System.out.println(age);
        return name.toUpperCase();
    };
}
