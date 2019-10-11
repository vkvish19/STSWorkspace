package personal.vishu.java.streams.terminal_streams;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

import java.util.Comparator;
import java.util.Optional;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class StreamsMinByMaxByExample
{
    public static void main(String[] args)
    {
        System.out.println("minBy_Example() = " + minBy_Example());
        System.out.println("maxBy_Example() = " + maxBy_Example());
    }
    
    private static Optional<Student> minBy_Example()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(minBy(Comparator.comparing(Student::getGpa)));
    }
    
    private static Optional<Student> maxBy_Example()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(maxBy(Comparator.comparing(Student::getGpa)));
    }
}
