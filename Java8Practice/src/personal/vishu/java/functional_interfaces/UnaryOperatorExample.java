package personal.vishu.java.functional_interfaces;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {

    static UnaryOperator<String> unaryOperatorStringConcat = str -> str.concat(" Vishu.");

    public static void main(String[] args) {
        System.out.println(unaryOperatorStringConcat.apply("it's ok"));
    }
}
