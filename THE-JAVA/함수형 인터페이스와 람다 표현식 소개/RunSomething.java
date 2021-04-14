package me.mac2.java8to11;

@FunctionalInterface
public interface RunSomething {

    // void doIt(); // 추상메소드를 딱 하나만 가지고 있는 인터페이스 -> 함수형 인터페이스

    int doIt(int number);

    static void printName() { // 자바 8부터 인터페이스에 public 생략 가능, static 메소드 정의 가능
        System.out.println("Mac2");
    }

    default void printAge() { // 마찬가지로 default도 정의 가능
      System.out.println("28");
    }
}
