package personal.vishu.java.optional;

import java.util.Optional;

public class OptionalPresentExample
{
    public static void main(String[] args)
    {
        /**
         * behavior of isPresent and ifPresent with some string value.
         */
        //isPresent
        Optional<String> stringOptional = Optional.ofNullable("hello Optional");
        System.out.println("stringOptional.isPresent() = " + stringOptional.isPresent());
        if(stringOptional.isPresent())
            System.out.println("stringOptional.get() = " + stringOptional.get());
        
        //ifPresent
        stringOptional.ifPresent( str -> System.out.println("str : " + str));
    
    
        /**
         * behavior of isPresent and ifPresent with null
         */
        //isPresent
        Optional<String> stringOptional1 = Optional.ofNullable(null);
        System.out.println("stringOptional1.isPresent() = " + stringOptional1.isPresent());
        if(stringOptional1.isPresent())
            System.out.println("stringOptional1.get() = " + stringOptional1.get());
    
        //ifPresent
        stringOptional1.ifPresent( str -> System.out.println("str : " + str));

    }
}
