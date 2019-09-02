package personal.vishu.java.lambdas;

public class RunnableLambdaExample {
    public static void main(String[] args) {
        //Legacy (prior to Java 8)
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside Runnable 1.");
            }
        };
        new Thread(runnable1).start();

        //Java 8
        Runnable runnableLambda = () -> System.out.println("Inside Runnable 2.");
        new Thread(runnableLambda).start();

        // Java 8 (without reference variable)
        new Thread( () -> System.out.println("Inside Runnable 3.")).start();
    }
}
