package personal.vishu.java.functional_interfaces;

import java.util.Comparator;
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {

    private static Comparator<Integer> comparatorNaturalOrder = Comparator.naturalOrder();

    private static BinaryOperator<Integer> binaryOperatorProductOfTwoIntegers = (num1, num2) -> num1 * num2;
    private static BinaryOperator<Integer> binaryOperatorMaxBy = BinaryOperator.maxBy(comparatorNaturalOrder);
    private static BinaryOperator<Integer> binaryOperatorMinBy = BinaryOperator.minBy(comparatorNaturalOrder);

    public static void main(String[] args) {
        System.out.println("Result of binaryOperatorProductOfTwoIntegers : "
                + binaryOperatorProductOfTwoIntegers.apply(4, 5));

        System.out.println("Result of binaryOperatorMaxBy : "
                + binaryOperatorMaxBy.apply(4, 5));

        System.out.println("Result of binaryOperatorMinBy : "
                + binaryOperatorMinBy.apply(4, 5));
    }
}
