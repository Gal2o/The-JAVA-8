package me.mac2.java8to11;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

public class LamdaPractice {

    public static void main(String[] args) {
//        Supplier<Integer> getNum = () -> {
//            return 10;
//        }

        // 위와 같다
        Supplier<Integer> getNum = () -> 10;

        BinaryOperator<Integer> get3Num = (a, b) -> a + b;

        // 변수 여러개 and 타입 명시
        BinaryOperator<Integer> get3NumType = (Integer a, Integer b) -> a + b;

        LamdaPractice lamdaPractice = new LamdaPractice();
        lamdaPractice.run();
    }

    private void run() {
        final int baseNumber = 10; // 로컬 변수

        // java 8에는 final을 생략하고 final 처럼 사용할 수 있는 effective final이 존재한다.
        // 어디서도 이 변수를 변경하지 않는 경우 -> effective final
        int effectiveNumber= 20;

        // 로컬 클래스
        class Localclass {
            void printbaseNumer() {
                int baseNumber = 11; // 내부에서 새로 정의 하면 덮임 - 쉐도잉
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스에서 로컬 변수를 참조
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                int baseNumber = 12; // 쉐도잉
                System.out.println(baseNumber);
            }
        };

        // 람다에서 로컬 변수를 참조
        IntConsumer printInt = (i) -> {
            // int baseNumber = 12; => void run() 과 같은 scope -> 같은 변수 선언 X
            System.out.println(i + baseNumber);
            System.out.println(i + effectiveNumber);
        };

        // 로컬, 익명 <-> 람다와 공통점 => final 로컬 변수를 참조 할 수 있다.
        // 차이점 : 로컬, 익명 클래스는 쉐도잉이 된다 , 람다는 쉐도잉 적용 안됨 (scope의 범위가 다르다)

        printInt.accept(10);

        // effectiveNumber++;
        // 값을 변경하려고 하면 effictive final 조건이 깨지게 되어 람다 함수에서 사용할 수 없다.
    }
}
