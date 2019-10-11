package personal.vishu.java.defaults;

import java.util.List;

public class MultiplierImpl implements Multiplier
{
    @Override
    public int multiply(List<Integer> integerList)
    {
        return integerList.stream()
                .reduce(1, (x,y) -> x * y);
    }
    
    /**
     * overriding default method.
     */
    @Override
    public int size(List<Integer> integerList)
    {
        System.out.println("\ninside MultiplierImpl class");
        return integerList != null ? integerList.size() : 0;
    }
}
