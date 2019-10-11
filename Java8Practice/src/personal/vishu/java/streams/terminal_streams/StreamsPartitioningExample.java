package personal.vishu.java.streams.terminal_streams;

import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class StreamsPartitioningExample
{
    private static Predicate<Student> gpaPredicate = student -> student.getGpa() >= 3.8;

    public static void main(String[] args)
    {
        System.out.println("partitioningBy_1() = " + partitioningBy_1());
        System.out.println("partitioningBy_2() = " + partitioningBy_2());
    }
    
    private static Map<Boolean,List<Student>> partitioningBy_1()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(partitioningBy(gpaPredicate));
    }
    
    private static Map<Boolean,Set<Student>> partitioningBy_2()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(partitioningBy(gpaPredicate, toSet()));
    }
}
