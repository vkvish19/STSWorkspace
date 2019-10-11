package personal.vishu.java.streams.terminal_streams;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.summingInt;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class StreamsSumAvgExample
{
    public static void main(String[] args)
    {
        System.out.println("sum() = " + sum());
        System.out.println("average() = " + average());
    }
    
    private static int sum()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(summingInt(Student::getNotebooks));
    }
    
    private static double average()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(averagingInt(Student::getNotebooks));
    }
}
