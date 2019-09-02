package personal.vishu.java.method_reference;

import java.util.function.Function;

public class FunctionMethodReferenceExample {

    private static Function<String, String> functionStringToUppercaseUsingMethodReference = String::toUpperCase;

    public static void main(String[] args) {
        System.out.println(functionStringToUppercaseUsingMethodReference.apply("this too Shall Pass Vishu."));
    }
}
