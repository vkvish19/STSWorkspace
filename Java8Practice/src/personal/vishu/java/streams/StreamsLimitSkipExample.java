package personal.vishu.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample
{
    public static void main(String[] args)
    {
        List<Integer> integerList = Arrays.asList(2, 5, 9, 12, 1, 7, 3, 76, 32, 234 , 1, -22, 4, 0, -124);
        List<Integer> integerList1 = new ArrayList<>();
        
        printLimitSum(integerList);
        printLimitSum(integerList1);
        
        printSkipSum(integerList);
        printSkipSum(integerList1);
    }
    
    private static void printSkipSum(List<Integer> integerList)
    {
        Optional<Integer> skipSum1 = skipExampleMethod1(integerList);
        if(skipSum1.isPresent())
            System.out.println("skipSum1.get() = " + skipSum1.get());
        else
            System.out.println("No inputs passes to 'skip'");
    }
    
    private static void printLimitSum(List<Integer> integerList)
    {
        Optional<Integer> limitSum1 = limitExampleMethod1(integerList);
        if(limitSum1.isPresent())
            System.out.println("limitSum.get() = " + limitSum1.get());
        else
            System.out.println("No inputs passed to 'limit'.");
    }
    
    private static Optional<Integer> limitExampleMethod1(List<Integer> integerList)
    {
        // returns the sum of the first 'n' number of elements in the list - passed in the limit(n)
        return integerList.stream()
                .limit(3)
                .reduce(Integer::sum);
    }
    
    private static Optional<Integer> skipExampleMethod1(List<Integer> integerList)
    {
        // returns the sum of the remaining elements after skipping the first 'n' number of elements from the list.
        // passed in the skip(n).
        return integerList.stream()
                .skip(5)
                .reduce(Integer::sum);
    }
}
