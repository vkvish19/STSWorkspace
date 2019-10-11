package personal.vishu.java.defaults;

public class Client14 implements Interface1, Interface4
{
    // HERE INTERFACE1 AND INTERFACE4 HAVE METHOD WITH SAME SIGNATURE AND HENCE THE CHILD CLASS WILL ALWAYS HAVE TO OVERRIDE SUCH METHODS TO OVERCOME COMPILATION ERROR.
    @Override
    public void methodA()
    {
        System.out.println("Inside method A : " + Client14.class);
    }
    
    public static void main(String[] args)
    {
        Client14 client14 = new Client14();
        client14.methodA();
    }
}
