package personal.vishu.java.streams.numeric_streams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamAggregateExample
{
    public static void main(String[] args)
    {
        int sum = IntStream.range(1, 5).sum();
        System.out.println("Sum is : " + sum);
    
        OptionalInt optionalIntMax = IntStream.rangeClosed(1, 50).max();
        System.out.println(optionalIntMax.isPresent() ? "Max value is : " + optionalIntMax.getAsInt() : "No max value present.");
    
        OptionalLong optionalLongMin = LongStream.rangeClosed(50, 100).min();
        System.out.println(optionalLongMin.isPresent() ? "Min value is : " + optionalLongMin.getAsLong() : "No Min value present.");
    
        OptionalDouble optionalDoubleAverage = IntStream.rangeClosed(1,10).average();
        System.out.println(optionalDoubleAverage.isPresent() ? "Average value is : " + optionalDoubleAverage.getAsDouble() : "No value is present.");
    }
}
