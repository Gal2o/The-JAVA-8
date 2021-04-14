package me.mac2.java8to11;

public class Foo {

    public static void main(String[] args) {
        // 자바 8 이전 만들어진 인터페이스를 사용하는 방법
//        // 익명 내부 클래스 anonymous inner class
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIt() {
//                System.out.println("Hello");
//            }
//        };

        // 자바 8 이상 부터 람다 표현식으로 가능
        // 함수형 인터페이스를 인라인으로 구현한 오브젝트

        RunSomething runSomething = (number) -> number + 10;
        System.out.println(runSomething.doIt(10));

        // pure function을 달성하기 위해서 -> 매개변수로 받은 값으로만 처리를 해야한다. 함수 밖에 있는 값을 변경하지 않는다.

        // 잘못된 예 1
        int basenumber = 10;
        RunSomething wrongSomething = (number) -> number + basenumber;
        // 하지만 basenumber를 final로 가정하고 참조만 한다면 사용 가능하다.

        // 잘못된 예 2
        RunSomething wrongSomething2 = new RunSomething() {
            int basenumber2 = 10; // 여기도 함수의 밖
            @Override

            public int doIt(int number) {
                basenumber2++;
                return number + basenumber2;
            }
        };

    }
}
