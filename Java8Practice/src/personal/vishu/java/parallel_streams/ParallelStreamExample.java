package personal.vishu.java.parallel_streams;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample
{
    public static void main(String[] args)
    {
        System.out.println("sumSequentialStream() = " + sumSequentialStream());
        System.out.println("sumParallelStream() = " + sumParallelStream());
    
        System.out.println("Sequential Result Performance Time : " + checkPerformanceResult(ParallelStreamExample::sumSequentialStream, 200));
        System.out.println("Parallel Result Performance Time : " + checkPerformanceResult(ParallelStreamExample::sumParallelStream, 200));
    }
    
    private static long checkPerformanceResult(Supplier<Integer> supplier, int numberOfTimes)
    {
        long startTime = System.currentTimeMillis();
        
        for(int i=0; i<numberOfTimes; i++)
        {
            supplier.get();
        }
        
        long endTime = System.currentTimeMillis();
        
        return endTime - startTime;
    }
    
    private static int sumSequentialStream()
    {
        return IntStream.rangeClosed(1, 1000000)
                .sum();
    }
    
    private static int sumParallelStream()
    {
        return IntStream.rangeClosed(1, 1000000)
                .parallel()
                .sum();
    }
}
