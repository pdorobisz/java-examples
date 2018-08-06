package examples.java8.lambdas;

// Ta adnotacja wymusza na kompilatorze sprawdzenie, ze interfejs posiada dokladnie jedna metode abstrakcyjna
// i dzieki temu mozna go uzyc w lambdzie (lambda bedzie implementacja tej metody).
@FunctionalInterface
interface Converter<F, T> {
    T convert(F f);

    // ok, moze byc wiele metod default. W lambdzie implementujacej abstrakcyjna metode nie mozna korzystac z metod default
    default String empty() {
        return "";
    }
}
