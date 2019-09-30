package personal.vishu.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsMinMaxValue
{
    public static void main(String[] args)
    {
        List<Integer> integerList = Arrays.asList(6, 3, 8, 10, 3);
        List<Integer> integerList1 = new ArrayList<>();

        printMaxValueExamples(integerList, integerList1);
        printMinValueExamples(integerList, integerList1);
    }
    
    private static void printMinValueExamples(List<Integer> integerList, List<Integer> integerList1)
    {
        System.out.println("Min value in the integerList using findMinIntegerValueInList() is : " + findMinIntegerValueInList(integerList));
        System.out.println("Min value in the integerList1 using findMinIntegerValueInList() is : " + findMinIntegerValueInList(integerList1));
    
        Optional<Integer> minIntegerOptional = findMinIntegerValueInListUsingOptional(integerList);
        if(minIntegerOptional.isPresent())
            System.out.println("minIntegerOptional= " + minIntegerOptional.get());
        else
            System.out.println("minIntegerOptional is empty");
    
        Optional<Integer> minIntegerOptional1 = findMinIntegerValueInListUsingOptional(integerList1);
        if(minIntegerOptional1.isPresent())
            System.out.println("minIntegerOptional1= " + minIntegerOptional1.get());
        else
            System.out.println("minIntegerOptional1 is empty");
    }
    
    private static void printMaxValueExamples(List<Integer> integerList, List<Integer> integerList1)
    {
        System.out.println("Max value in the integerList using findMaxIntegerValueInList() is : " + findMaxIntegerValueInList(integerList));
        System.out.println("Max value in the integerList1 using findMaxIntegerValueInList() is : " + findMaxIntegerValueInList(integerList1));
    
        Optional<Integer> maxIntegerOptional = findMaxIntegerValueInListUsingOptional(integerList);
        if(maxIntegerOptional.isPresent())
            System.out.println("maxIntegerOptional= " + maxIntegerOptional.get());
        else
            System.out.println("maxIntegerOptional is empty");
    
        Optional<Integer> maxIntegerOptional1 = findMaxIntegerValueInListUsingOptional(integerList1);
        if(maxIntegerOptional1.isPresent())
            System.out.println("maxIntegerOptional1= " + maxIntegerOptional1.get());
        else
            System.out.println("maxIntegerOptional1 is empty");
    }
    
    private static int findMaxIntegerValueInList(List<Integer> integerList)
    {
        return integerList.stream()
                .reduce(0, (x, y) -> x > y ? x : y);
    }
    
    private static Optional<Integer> findMaxIntegerValueInListUsingOptional(List<Integer> integerList)
    {
        return integerList.stream()
                .reduce((x, y) -> x > y ? x : y);
    }
    
    private static int findMinIntegerValueInList(List<Integer> integerList)
    {
        //ALWAYS USE OPTIONAL FOR MIN VALUE. NEVER USE THE DEFAULT. IT WILL BE ERRONEOUS AS YOU CAN SEE THIS CASE.
        return integerList.stream()
                .reduce(0, (x, y) -> x < y ? x : y);
    }
    
    private static Optional<Integer> findMinIntegerValueInListUsingOptional(List<Integer> integerList)
    {
        return integerList.stream()
                .reduce((x, y) -> x < y ? x : y);
    }
}
