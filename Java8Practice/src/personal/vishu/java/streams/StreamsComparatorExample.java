package personal.vishu.java.streams;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class StreamsComparatorExample
{
    public static void main(String[] args)
    {
        System.out.println("Students sorted by Name : ");
        sortStudentsByName().forEach(System.out::println);
    
        System.out.println("\nStudents sorted by GPA : ");
        sortStudentsByGpa().forEach(System.out::println);
    
        System.out.println("\nStudents sorted by GPA DESCENDING: ");
        sortStudentsByGpaDescending().forEach(System.out::println);

    }
    
    private static List<Student> sortStudentsByName()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(toList());
    }
    
    private static List<Student> sortStudentsByGpa()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa))
                .collect(toList());
    }
    
    private static List<Student> sortStudentsByGpaDescending()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed())
                .collect(toList());
    }
    
}
