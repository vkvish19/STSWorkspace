package personal.vishu.java.defaults;

import java.util.Arrays;
import java.util.List;

public class MultiplierClient
{
    public static void main(String[] args)
    {
        Multiplier multiplier = new MultiplierImpl();
        List<Integer> integerList = Arrays.asList(1, 3, 5, 10);
        System.out.println("multiplier.multiply(integerList) = " + multiplier.multiply(integerList));
        
        System.out.println("multiplier.size(integerList) = " + multiplier.size(integerList));
        System.out.println("multiplier.size(null) = " + multiplier.size(null));
        
        System.out.println("static method isEmpty for integerList is : " + Multiplier.isEmpty(integerList));
        System.out.println("static method isEmpty for null is : " + Multiplier.isEmpty(null));
    }
}
