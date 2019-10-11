package personal.vishu.java.parallel_streams;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamBoxedExample
{
    public static void main(String[] args)
    {
        List<Integer> integerList = IntStream.rangeClosed(1, 10000)
                .boxed()
                .collect(toList());
        
        sequentialSum(integerList);
        parallelSum(integerList);
    }
    
    private static int sequentialSum(List<Integer> integerList)
    {
        long startTime = System.currentTimeMillis();
        int sum = integerList
                .stream()
                .reduce(0, (a,b) -> a+b);
        long endTime = System.currentTimeMillis();
        System.out.println("Duration of sequential stream : " + (endTime-startTime));
        
        return sum;
    }
    
    private static int parallelSum(List<Integer> integerList)
    {
        long startTime = System.currentTimeMillis();
        int sum = integerList
                .parallelStream()
                .reduce(0, (a,b) -> a+b);   // perform the unboxing from Integer to int.
        long endTime = System.currentTimeMillis();
        System.out.println("Duration of parallel stream : " + (endTime-startTime));
        
        return sum;
    }
}
