package personal.vishu.java.defaults;

// SORRY FOR NOT OBEYING NAMING CONVENTIONS

public interface Interface1
{
    default void methodA()
    {
        System.out.println("Inside method A : " + Interface1.class);
    }
}
