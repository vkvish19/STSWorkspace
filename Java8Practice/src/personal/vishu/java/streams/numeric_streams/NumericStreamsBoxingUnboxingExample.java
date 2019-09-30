package personal.vishu.java.streams.numeric_streams;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsBoxingUnboxingExample
{
    public static void main(String[] args)
    {
        List<Integer> integerList = boxing();
        System.out.println("Boxing : " + boxing());
        System.out.println("Unboxing : " + unboxing(integerList));
    }
    
    // BOXING - int to Integer
    private static List<Integer> boxing()
    {
        return IntStream.rangeClosed(1, 10) // intstream of 1 to 50
                // int
                .boxed()
                // Integer
                .collect(toList()); //List<Integer>
    }
    
    // UNBOXING - Integer to int
    private static int unboxing(List<Integer> integerList)
    {
        return integerList.stream()
                // wrapper Integer values
                .mapToInt(Integer::intValue)    //intstream of intValue wrapper class
                .sum();
    }
}
