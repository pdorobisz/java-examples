package examples.generics;

import java.util.Collection;

public class Inheritance {
    public static void main(String[] args) {
        A a = new B();
        Integer a1 = a.get1(); // skompiluje sie, ale podczas wykonywania wystapi ClassCastException (chyba, ze get1 zwroci null)
        new B().get();
    }

    private static class A {
        public void set(Object o) {
        }

        public <T> void set1(T o) {
        }

        public <T> T get1() {
            return null;
        }

        public <T> void set2(T o) {
        }

        public void set3(Collection<String> o) {
        }

        public void set4(Collection o) {
        }

        public Object get() {
            return null;
        }
    }

    private static class B extends A {
        // Blad, ta metoda po erasure bedzie miala taki sam argument jak metoda z nadklasy, ale te metody sa parametryzowane
        // roznymi typami.
//        public <T> void set(T o) {
//        }

        // przeciazenie (overload), a nie przedefiniowanie (override), gdyz mamy rozne sygnatury
        public void set1(String o) {
        }

        // przedefiniowanie, bo jest ta sama sygnatura (zwracany typ nie wchodzi w sklad sygnatury metody)
        @Override
        public String get1() {
            return "abc";
        }

        @Override
        public <T extends Object> void set2(T o) {
        }

        // Nadpisuje metode z klasy bazowej, gdyz sygnatura tej metody jest "override-equivalent" (jest subsignature sygnatury metody
        // z klasy bazowej).
        // Subsygnatura (subsignature) - gdy sygnatura metody jest identyczna z sygnatura innej metody lub identyczna z jej erasure.
        @Override
        public void set3(Collection o) {
        }

        // Blad, bo zwracany typ jest niekompatybilny ze zwracanym typem w nadklasie (typy sa kompatybilne gdy: te same typy prymitywne, identyczne typy,
        // zwracany typ w klasie pochodnej jest podtypem typu zwracanego w nadklasie, typ raw w podklasie jest taki sam jak erasure w nadklasie lub jest
        // jego podtypem).
//        public int set3(Collection o) {
//            return 0;
//        }

        // Blad, sygnatura tej metody nie jest subsygnatura metody z nadklasy (nie sa "override-equivalent").
//        public void set4(Collection<String> o) {
//        }
    }
}
