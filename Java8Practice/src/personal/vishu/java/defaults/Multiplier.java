package personal.vishu.java.defaults;

import java.util.List;

public interface Multiplier
{
    int multiply(List<Integer> integerList);
    
    // NOTE: we can override default methods in the implementation classes.
    default int size(List<Integer> integerList)
    {
        System.out.println("\ninside Multiplier interface");
        return integerList != null ? integerList.size() : 0;
    }
    
    // NOTE: we cannot override the static methods in the implementation classes.
    static boolean isEmpty(List<Integer> integerList)
    {
        return integerList == null || integerList.size() == 0;
    }
}
