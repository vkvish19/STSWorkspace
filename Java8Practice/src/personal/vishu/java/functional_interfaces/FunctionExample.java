package personal.vishu.java.functional_interfaces;

import java.util.function.Function;

public class FunctionExample {

    static Function<String, String> functionStringToUpperCase = String::toUpperCase;
    static Function<String, String> functionStringConcat = string -> string.toUpperCase().concat(" Vishu.");

    public static void main(String[] args) {
        System.out.println("Result is : " + functionStringToUpperCase.apply("this too Shall Pass"));

        System.out.println("Result of andThen is : "
                + functionStringToUpperCase.andThen(functionStringConcat).apply("this too Shall Pass"));

        System.out.println("Result of Compose is : "
                + functionStringToUpperCase.compose(functionStringConcat).apply("this too Shall Pass"));

        String s = performConcat("it's ok");
        System.out.println("performConcat result is : " + s);
    }

    public static String performConcat(String s) {
        return functionStringConcat.apply(s);
    }
}
