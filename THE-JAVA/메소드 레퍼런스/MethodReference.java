package me.mac2.java8to11;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {
    public static void main(String[] args) {
        UnaryOperator<String> hi = (s) -> "hi " + s;

//        메소드 레퍼런스로 사용한 방법
        UnaryOperator<String> MRhi = Greeting::hi;

//        특정한 인스턴스의 static 메소드가 아닌 특정 메소드를 사용하고 싶다면
        Greeting greeting = new Greeting();
        UnaryOperator<String> hihi = greeting::hello;
//        apply를 해야 무슨 일이 벌어진다 안하면 아무것도 안함
        System.out.println(hihi.apply("Mac2"));

//        입력 값은 없는데 리턴 값이 생성자 타입인 것
        Supplier<Greeting> newGreeting = Greeting::new;
//        get을 해야 생성자가 만들어 진다.
        newGreeting.get();

//        입력값은 있고 리턴 값이 생성자
//        Supplier와 형태는 같지만 다른 생성자를 사용한다
        Function<String, Greeting> MacGreeting = Greeting::new;
//        System.out.println(MacGreeting.apply("Mac"));
//        의 결과 값은 me.mac2.java8to11.Greeting@6b143ee9 생성자의 주소를 출력한다.

//        getter 가 없으므로 만들어 준다
//        getter 가 없으면 Greeting 생성자의 주소만 출력하므로 getName으로 가져와야한다.
        System.out.println(MacGreeting.apply("Mac2").getName());

//        임의 객체의 인스턴스 메소드 참조
        String[] names = {"mac", "galio", "lol"};
        // comparator 람다로 사용
        Arrays.sort(names, (o1, o2) -> 0);
        System.out.println(Arrays.toString(names));

        // 대소문자 무시하고 문자열 비교
        String[] names2 = {"mac", "galio", "lol"};
        Arrays.sort(names2, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names2));

    }
}
