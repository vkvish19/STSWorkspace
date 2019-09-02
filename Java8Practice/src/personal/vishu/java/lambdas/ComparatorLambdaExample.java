package personal.vishu.java.lambdas;

import java.util.Comparator;

public class ComparatorLambdaExample {
    public static void main(String[] args) {
        //prior to Java 8
        Comparator<Integer> comparatorLegacy = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);    // 0 -> o1=o2
                                            // 1 -> o1>o2
                                            // -1 -> o1<o2
            }
        };
        System.out.println("Result of Legacy Comparator is: " +comparatorLegacy.compare(7, 4));

        //Java 8
        Comparator<Integer> comparatorLambda = (a, b) -> a.compareTo(b);
        System.out.println("Result of Comparator using Lambda is: " +comparatorLambda.compare(7, 4));

        Comparator<Integer> comparatorLambda2 = Comparator.naturalOrder();
        System.out.println("Result of Comparator using Comparator naturalOrder() method is: "
                +comparatorLambda2.compare(7, 4));

    }
}
