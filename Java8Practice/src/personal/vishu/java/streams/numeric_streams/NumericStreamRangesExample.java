package personal.vishu.java.streams.numeric_streams;

import java.util.stream.IntStream;

public class NumericStreamRangesExample
{
    public static void main(String[] args)
    {
        IntStream intStreamRange = IntStream.range(1, 50);
        System.out.println("intStreamRange.count() = " + intStreamRange.count());
        
        IntStream intStreamRangeClosed = IntStream.rangeClosed(1, 50);
        System.out.println("intStreamRangeClosed.count() = " + intStreamRangeClosed.count());
    
        System.out.print("IntStream Range (1,50) -> ");
        IntStream.range(1, 50).forEach(value -> System.out.print(value + ", "));
    
        System.out.print("\nIntStream Range Closed (1,50) -> ");
        IntStream.rangeClosed(1, 50).forEach(value -> System.out.print(value + ", "));
        
        // LongStream also supports Range and RangeClosed methods.
        // DoubleStream DOESN'T support Range and RangeClosed methods. Instead we can use below way to get it - if needed.
        System.out.println("\nDouble Stream from IntStream : ");
        IntStream.rangeClosed(1, 50).asDoubleStream().forEach(value -> System.out.print(value + ", "));
    }
}
