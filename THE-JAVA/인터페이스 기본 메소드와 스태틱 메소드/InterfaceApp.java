package me.mac2.java8to11;

public class InterfaceApp {
    public static void main(String[] args) {
        InterfaceFoo foo = new InterfaceFoo("mac2");

        foo.printName();
        foo.printNameUpperCase();

        // static 메소드는 생성자 안만들고 가져올 수 있다.
        InterfaceFoo.printAnything();

    }
}
