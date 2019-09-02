package personal.vishu.java.functional_interfaces;

import java.util.function.Predicate;

public class PredicateExample {

    private static Predicate<Integer> isEven = i -> i%2==0;
    private static Predicate<Integer> isDivisibleByFive = i -> i%5==0;

    public static void main(String[] args) {
        predicateAnd();
        predicateOr();
        predicateNegate();
    }

    public static void predicateAnd() {
        System.out.println("Predicate AND result is: " + isEven.and(isDivisibleByFive).test(10)); // predicate chaining
        System.out.println("Predicate AND result is: " + isEven.and(isDivisibleByFive).test(9)); // predicate chaining
    }

    public static void predicateOr() {
        System.out.println("Predicate OR result is: " + isEven.or(isDivisibleByFive).test(10));
        System.out.println("Predicate OR result is: " + isEven.or(isDivisibleByFive).test(6));
    }

    public static void predicateNegate() {
        System.out.println("Predicate NEGATE result is: " + isEven.or(isDivisibleByFive).negate().test(8));
        System.out.println("Predicate NEGATE result is: " + isEven.negate().or(isDivisibleByFive).test(7));
    }
}
