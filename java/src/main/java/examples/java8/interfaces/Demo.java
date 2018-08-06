package examples.java8.interfaces;

public class Demo {

    public static void main(String[] args) {
        Man jasiu = new Man("Jasiu", 5);
        // mamy efekt wielokrotnego dziedziczenia - klasa ma implementacje z dwoch roznych interfejsow
        System.out.println(jasiu.play("misiu"));
        System.out.println(jasiu.walk("drzwi"));
        System.out.println(jasiu.sayHello("Malgosia"));
    }
}
