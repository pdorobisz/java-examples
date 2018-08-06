package examples.initialization;

public class InnerAndOuter {

    public static void main(String[] args) {
        OuterClass outer = new OuterClass("Hello");

        // stworzenie instancji klasy wewnetrznej powiazanej z instancja klasy zewnetrznej (outer)
        OuterClass.InnerClass inner = outer.new InnerClass("world");
        System.out.println(inner.getText());

        // zmiana w klasie zewnetrznej jest widoczna w powiazanej z nia klasa wewnetrzna
        outer.setText("Bye");
        System.out.println(inner.getText());
    }


    private static class OuterClass {

        private String text;

        private OuterClass(String text) {
            this.text = text;
        }

        private void setText(String text) {
            this.text = text;
        }

        /////// Klasa wewnetrzna
        public class InnerClass {

            private String b;

            public InnerClass(String b) {
                this.b = b;
            }

            public String getText() {
                return text + ", " + b;
            }
        }
    }
}
