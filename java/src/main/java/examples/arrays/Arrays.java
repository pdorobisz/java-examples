package examples.arrays;

public class Arrays {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int[] ints0 = new int[0]; // pusta tablica o okreslonym rozmiarze
        int[] ints1 = {1, 2, 3,}; // tablica z zawartoscia (tak mozna zrobic tylko przy deklaracji zmiennej). Przecinek na koncu jest dopuszczalny.
        // ints = { 1, 2, 3 }; // blad, nie jest to deklaracja zmiennej typu tablicowego
        int[] ints2 = new int[]{4, 5, 6,}; // mozna uzyca przy deklaracji...
        ints2 = new int[]{4, 5, 6,}; // ... jak i pozniej

        String[] strings0 = new String[0];
        String[] strings1 = {"a", "b", "c"};
        String[] strings2 = new String[]{"d", "e", "f"};
        strings2 = new String[]{"d", "e", "f"};

        Object[][] objects = {{new MyClass(), "string", 1}};
        Object[] objects1 = {new Object[]{1, "a"}};
        // Object[] objects2 = { { 1, "a" } }; // blad "cannot convert from int[] to Object"
        Object[][] objects3 = {{1, "a"}}; // ok, bo jako typ mamy tablice tablic
        objects1 = new Object[][]{{new MyClass(), "string", 1}};

        try {
            // Nie ma sensu przypisywac tablicy do referencji wskazujacej na tablice nadtypow.
            MyClass[] myClassArray = new MySubclass[10];
            myClassArray[0] = new MyClass(); // ArrayStoreException, bo przypisujemy zly typ
        } catch (ArrayStoreException e) {
            e.printStackTrace();
        }
    }

    // zwracanie tablicy z metody

    public static int[] method1() {
        // return { 1 }; // blad, nie jest to deklaracja zmiennej
        return new int[]{1};
    }

    public static int[][] method2() {
        return new int[][]{{1, 2}, {3, 4}};
    }

    public static int[][][] method3() {
        return new int[][][]{{{1, 2}, {3, 4}}};
    }

    public static MyClass[][][] method3_1() {
        return new MyClass[][][]{{{new MyClass()}}};
    }

    public static Object[] method4() {
        // jako zwracany typ mozna tez podac Object[][]
        return new String[][]{{"a", "a"}};
    }

    public static class MyClass {
    }

    public static class MySubclass extends MyClass {
    }
}
