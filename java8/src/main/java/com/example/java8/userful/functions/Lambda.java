package com.example.java8.userful.functions;

import com.example.java8.userful.Person;

import java.util.HashMap;
import java.util.function.BiConsumer;

public class Lambda {
    @FunctionalInterface
    public static interface Converter<F, T> {
        T convert(F from);
    }

    static class Something {
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }

    interface PersonFactory<P extends Person> {
        P create(String firstName, String lastName);
    }

    public static void main(String[] args) {
        Converter<String, Integer> integerConverter1 = (from) -> Integer.valueOf(from);
        Integer converted1 = integerConverter1.convert("123");
        System.out.println(converted1);   // result: 123

        // method reference

        Converter<String, Integer> integerConverter2 = Integer::valueOf;
        Integer converted2 = integerConverter2.convert("123");
        System.out.println(converted2);   // result: 123

        Something something = new Something();
        Converter<String, String> stringConverter = something::startsWith;
        String converted3 = stringConverter.convert("Java");
        System.out.println(converted3);    // result J
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person.firstName + person.lastName);

        //BiConsumer Example

        BiConsumer<String, Integer> printKeyAndValue = (key,value) -> System.out.println(key+"-"+value);
        printKeyAndValue.accept("One",1);
        printKeyAndValue.accept("Two",2);
        printKeyAndValue.accept("Three",3);
        printKeyAndValue.andThen((k,v) -> System.out.println(v+"-"+k));
        printKeyAndValue.accept("four",4);
        //One-1
        //Two-2
        //Three-3
        //four-4

        System.out.println("##################");

        //Java Hash-Map foreach supports BiConsumer
        HashMap<String, Integer> dummyValues = new HashMap<>();
        dummyValues.put("One", 1);
        dummyValues.put("Two", 2);
        dummyValues.put("Three", 3);
        dummyValues.forEach((key,value) -> System.out.println(key+"-"+value));
    }
}
