package personal.vishu.java.defaults;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DefaultMethodsExample
{
    public static void main(String[] args)
    {
        List<String> stringList = Arrays.asList("Rachel", "Ross", "Monica", "Chandler", "Phoebe", "Joey");
    
        /**
         * Prior to Java 8
         */
        Collections.sort(stringList);
        System.out.println("Sorted list using Collections.sort() = " + stringList);
    
        /**
         * Java 8
         */
        stringList.sort(Comparator.reverseOrder());
        System.out.println("Sorted list using List.sort() reverse order : " + stringList);

        stringList.sort(Comparator.naturalOrder());
        System.out.println("Sorted list using List.sort() natural order : " + stringList);
    }
}
