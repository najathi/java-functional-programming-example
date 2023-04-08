package finalsection;

import java.util.function.Consumer;

public class Callbacks {
    public static void main(String[] args) {
        hello("Mohamed", "Najathi", null);
        System.out.println();
        hello("Mohamed", null, value -> {
            System.out.println("no lastname provided for " + value);
        });

        System.out.println();
        hello2("Mohamed", null, () -> {
            System.out.println("no lastname provided!");
        });
    }

    static void hello(String firstName, String lastName, Consumer<String> callback){
        System.out.println(firstName);
        if (lastName != null) System.out.println(lastName);
        else callback.accept(firstName);
    }

    static void hello2(String firstName, String lastName, Runnable callback){
        System.out.println(firstName);
        if (lastName != null) System.out.println(lastName);
        else callback.run();
    }

//    function hello(firstName, lastName, callback) {
//        console.log(firstName)
//        if(lastName) console.log(lastName)
//        else callback()
//    }
//    hello("Mohamed", null, ()=> {console.log("Last name is not found!")})
}
