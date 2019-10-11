package personal.vishu.java.streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamsOfGenerateIterateExample
{
    public static void main(String[] args)
    {
        System.out.println("Stream 'Of' Example: ");
        Stream<String> stringStream = Stream.of("adam", "julie", "daniel");
        stringStream.forEach(System.out::println);
    
        System.out.println("\nStream 'Iterate' example: ");
        Stream.iterate(1, x -> x*2)
                .limit(10)
                .forEach(System.out::println);
    
        System.out.println("\nStream 'Generate' Example: ");
        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier)
                .limit(10)
                .forEach(System.out::println);
    }
}
