package personal.vishu.java.optional;

import java.util.Optional;

public class OptionalOfEmptyNullableExample
{
    public static void main(String[] args)
    {
        System.out.println("ofNullable() = " + ofNullable());
        System.out.println("ofNullable().get() = " + ofNullable().get());
    
        System.out.println("of() = " + of());
        System.out.println("of().get() = " + of().get());
    
        System.out.println("empty() = " + empty());
    }
    
    private static Optional<String> ofNullable()
    {
        Optional<String> stringOptional = Optional.ofNullable("Hello");
//        Optional<String> stringOptional = Optional.ofNullable(null);
        return stringOptional;
    }
    
    // Optional.of() expects the value to be valid.
    // null -> will throw an exception
    private static Optional<String> of()
    {
        Optional<String> stringOptional = Optional.of("Hello");
//        Optional<String> stringOptional = Optional.of(null);
        return stringOptional;
    }
    
    private static Optional<String> empty()
    {
        return Optional.empty();
    }
}
