package io.javabrains.reactiveworkshop;

import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream


        StreamSources.intNumbersStream().forEach(x -> System.out.println(x));
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5

        StreamSources.intNumbersStream().filter(x -> x < 5).forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here

        //StreamSources.intNumbersStream().filter(x -> x > 5).collect(Collectors.toList());

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1

        System.out.println(StreamSources.intNumbersStream().filter(x -> x > 5).findFirst().orElse(-1));

        // Print first names of all users in userStream


        StreamSources.userStream().forEach(x -> System.out.println(x.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream


        System.out.println(StreamSources.userStream().filter(user -> StreamSources.intNumbersStream().toList().contains(user.getId())).collect(Collectors.toList()));

        Predicate<User> predicate = user -> StreamSources.intNumbersStream().toList().contains(user.getId());

        System.out.println(StreamSources.userStream().filter(predicate).collect(Collectors.toList()));
    }

}
