package examples.generics;

public class Wildcards {

    public static void main(String[] args) {
        // 1
        Box<?> box1 = new Box<Integer>();
        box1.setData(null); // ok
        // box1.setData(new Integer(1)); // blad kompilacji, kompilator oczekuje, argumentu typu "?" (nieznany), czyli nie da sie nic przekazac (oprocz null)!
        // box1.setData(new Object()); // blad kompilacji, jw.
        Object data = box1.getData(); // ok, metoda jest potraktowana tak jakby zwracala Object (referencje do nieznanych typow
        // sa traktowane jak referencje do Object)

        // 2
        Box rawBox = new Box<Integer>();
        rawBox.setData(new Integer(2)); // ok, mozemy przypisywac co chcemy

        // 3
        Box<Object> box2 = rawBox; // warning "Unchecked assignment"
        box2.setData(null);
        box2.setData(1); // ok
        box2.setData("ala ma kota"); // ok, przypisujemy String mimo, ze Box jest parametryzowany typem Integer!
        box2.setData(new Object()); // ok
        System.out.println("data: " + box2.getData());

        // 4
        Box<? extends Integer> box3 = new Box<Integer>();
        // box3.setData(new Integer(2)); // blad kompilacji, gdyz setData moze przyjmowac tez podklasy Integer
        Integer data3 = box3.getData(); // wiemy, ze zwraca Integer

        // 5
        Box<? super Integer> box4 = new Box<Integer>();
        box4.setData(new Integer(2)); // ok, setData moze przyjmowac Integer lub jego nadtyp
        // box4.setData((Number) 1); // blad kompilacji, bo kompilator nie wie jaki nadtyp przyjmuje Box (np. moze przyjmowac Comparable, a Number go nie implementuje)
        Object data4 = box4.getData(); // nie wiemy jaki typ jest zwracany
    }
}

class Box<T> {
    // W runtimie to pole jest typu Object, wiec mozemy przypisac np. String, mimo, ze klasa byla parametryzowana Integerem.
    private T data;

    T getData() {
        return data;
    }

    void setData(T data) {
        this.data = data;
    }
}
