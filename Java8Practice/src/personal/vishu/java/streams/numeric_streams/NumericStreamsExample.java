package personal.vishu.java.streams.numeric_streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsExample
{
    public static void main(String[] args)
    {
        List<Integer> integerList = Arrays.asList(1, 2, 3,4 ,5, 6);
        System.out.println("Sum of Numbers using sumOfNumbers : " + sumOfNumbers(integerList));
    
        System.out.println("sumOfNumbersUsingIntStream() = " + sumOfNumbersUsingIntStream());
    }
    
    private static int sumOfNumbers(List<Integer> integerList)
    {
        return integerList.stream()
                .reduce(0, Integer::sum );
    }
    
    private static int sumOfNumbersUsingIntStream()
    {
        return IntStream.rangeClosed(1, 6)
                .sum();
    }
}
