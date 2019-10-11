package personal.vishu.java.streams;

import static java.util.stream.Collectors.toList;

import java.util.List;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class StreamsFilterExample
{
    public static void main(String[] args)
    {
        System.out.println("filterFemaleStudents() : ");
        filterFemaleStudents().forEach(System.out::println);
    }
    
    private static List<Student> filterFemaleStudents()
    {
        return StudentDatabase.getAllStudents()
                .stream()   //Stream<Student>
                .filter(student -> student.getGender().equalsIgnoreCase("female"))  //Stream<Student> - only female students
                .collect(toList());
    }
}
