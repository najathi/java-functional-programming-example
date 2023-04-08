package fuctionaliterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("07541413311"));
        System.out.println(isPhoneNumberValid("08541413311"));
        System.out.println(isPhoneNumberValid("090541413311"));

        System.out.println();
        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07541413311"));
        System.out.println(isPhoneNumberValidPredicate.test("08541413311"));
        System.out.println(isPhoneNumberValidPredicate.test("090541413311"));

        System.out.println();
        System.out.println("Is phone number valid and contains number 3 = " + isPhoneNumberValidPredicate.and(containsNumber3).test("07541413311"));
        System.out.println("Is phone number valid and contains number 3 = " + isPhoneNumberValidPredicate.and(containsNumber3).test("075414111"));
        System.out.println("Is phone number valid or contains number 3 = " + isPhoneNumberValidPredicate.or(containsNumber3).test("075414111"));

    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("7");

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }
}
