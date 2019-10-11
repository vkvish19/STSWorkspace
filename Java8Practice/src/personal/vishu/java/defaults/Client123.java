package personal.vishu.java.defaults;

// SORRY FOR NOT OBEYING NAMING CONVENTIONS

public class Client123 implements Interface1, Interface2, Interface3
{
    public static void main(String[] args)
    {
        Client123 client123 = new Client123();
        client123.methodA();    // resolves to the child implementation.
        client123.methodB();
        client123.methodC();
    
    }
    
    //1 -> class that implements the Interface.
    //2 -> the sub interface that extends the Interface.
    
    @Override
    public void methodA()
    {
        System.out.println("Inside method A : " + Client123.class);
    }
}
