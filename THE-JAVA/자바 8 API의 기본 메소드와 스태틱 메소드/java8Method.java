package me.mac2.java8to11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class java8Method {
    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
        name.add("Mac2");
        name.add("gal2o");
        name.add("toby");
        name.add("foo");

//        name.forEach(System.out::println);
//
//        for(String n : name) {
//            System.out.println(n);
//        }

        // 쪼갤 수 있는 기능을 가진 Iterator
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();

        // 나눠서 출력할 수 있다. (페러럴 하게 출력을 할 때, 순서가 중요하지 않을 때)
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("============");
        while(spliterator1.tryAdvance(System.out::println));

        // spliterator 을 이용하여 구현 되어 있는 stream()
        name.stream();
        long k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("M"))
                .count();

        System.out.println(k);

        // predicate 에 해당하는 메소드
        name.removeIf(s -> s.startsWith("M"));
        // "M" 으로 시작 하는 것을 빼라
        name.forEach(System.out::println);

        // 정렬 할 때는 comparator 을 사용함
//        name.sort(String::compareToIgnoreCase);
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());
    }
}
