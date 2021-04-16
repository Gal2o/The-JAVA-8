package me.mac2.java8to11;

public interface InterfaceDescription {

    void printName();

//     새로운 기능을 추가하면 interface에서 컴파일 에러가 발생한다! (추가로 override 하지 않았기 때문에)
//     void printNameUpperCase();

//    하지만 default 키워드를 사용하면 추가로 implements하는 클래스에서 따로 정의를 안해줘도 된다
//    하지만 이러한 default 메소드가
//    많은 인스턴스들이 사용할 때, 항상 제대로 동작하는 보장이 없다 (ex. getName에 무슨 인자가 올지 모름)
//    @implSpec으로 명시해 주는 것도 좋음
    /*
     * @implSpec
     * 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

//   하지만 Object 인터페이스를 선언하는 건 아무런 문제가 없다
    String toString();

    String getName();
}
