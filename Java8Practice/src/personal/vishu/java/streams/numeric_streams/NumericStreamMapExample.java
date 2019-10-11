package personal.vishu.java.streams.numeric_streams;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamMapExample
{
    public static void main(String[] args)
    {
        System.out.println("mapToObj : " + mapToObj());
        System.out.println("MapToLong : " + mapToLong());
        System.out.println("mapToDouble : " + mapToDouble());
    }
    
    private static List<Integer> mapToObj()
    {
        return IntStream.rangeClosed(1, 10)
                .mapToObj( i -> {
                    return new Integer(i);
                })
                .collect(toList());
    }
    
    private static long mapToLong()
    {
        return IntStream.rangeClosed(1,20) // intstream
                // i is passed from intstream
                .mapToLong(i -> i)  // convert intstream to longstream
                .sum(); // sum return long
    }
    
    private static double mapToDouble()
    {
        return IntStream.rangeClosed(1, 7) // intstream
                // i is passed from intstream
                .mapToDouble(i -> i)    // convert intstream to doublestream
                .sum(); // sum return double
    }
}
