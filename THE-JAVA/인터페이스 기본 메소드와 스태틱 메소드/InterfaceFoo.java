package me.mac2.java8to11;

public class InterfaceFoo implements InterfaceDescription, InterfaceBar {

    String name;

    public InterfaceFoo(String name) {
        this.name = name;
    }

//    입맛에 따라 default 메소드를 재정의 할 수 있다.
//    Object 에 있는 메소드들은 재정의 할 수 없다. (equal, hasCode)
//    default void toString() {
//        에러 발생!
//    }

    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase() + " 재정의 하였습니다.");
    }

//  InterfaceBar를 동시에 implements 한다고 하면 에러가 발생 (누굴 써야하는지 몰라서)
//  재정의 하면 문제가 발생하지 않는다

    static void printAnything() {
        System.out.println("어디서든 사용해");
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
