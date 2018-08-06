package examples.java8.interfaces;

public class Man implements Person, Child {

    private String name;
    private int age;

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    // trzeba zdefiniowac ta metode bo obydwa interfejsy dostarczaja jej implementacji
    @Override
    public String sayHello(String name) {
        return "hello " + name;
//        return ((Person) this).sayHello(name);
    }
}
