package me.mac2.java8to11;

import java.util.function.*;

public class PlusFoo {
    public static void main(String[] args) {
//        Plus10 plus10 = new Plus10();
//        System.out.println(plus10.apply(10));

        // 위에거와 동일, 아래 거는 람다 표현식
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        System.out.println(plus10.apply(10));

        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println(multiply2.apply(10));

        // Function을 만들어서 apply
        Function<Integer, Integer> multipleAndPlus = plus10.compose(multiply2);
        System.out.println(multipleAndPlus.apply(10));

        // 따로 함수 안만들고 apply
        System.out.println(plus10.andThen(multiply2).apply(10));

        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        // 무조건 10을 리턴 하겠다.
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        Predicate<String> startsWithMac2 = (s) -> s.startsWith("Mac2");
        Predicate<Integer> isEven = (i) -> i % 2 == 0;

        //plus10 메소드처럼 같은 타입이 두 개 일때 하나로 합쳐서 사용 가능
        UnaryOperator<Integer> plus20 = (i) -> i + 10;

        // 마찬가지로 입력 값 세 개가 동일 타입일 때 하나로 합쳐서 가능
        BinaryOperator<Integer> plus30 = (i, j) -> i + 10;
    }
}
