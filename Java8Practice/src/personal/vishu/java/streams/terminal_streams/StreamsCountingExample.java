package personal.vishu.java.streams.terminal_streams;

import static java.util.stream.Collectors.counting;

import personal.vishu.java.data.StudentDatabase;

public class StreamsCountingExample
{
    public static void main(String[] args)
    {
        System.out.println("count() = " + count());
    }
    
    private static long count()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() >= 3.9)
                .collect(counting());
    }
}
