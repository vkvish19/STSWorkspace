package personal.vishu.java.streams.terminal_streams;

import static java.util.stream.Collectors.joining;

import java.util.stream.Collectors;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class StreamsJoiningExample
{
    public static void main(String[] args)
    {
        System.out.println("joining_1() = " + joining_1());
        System.out.println("joining_2() = " + joining_2());
        System.out.println("joining_3() = " + joining_3());
    }
    
    // without delimiter
    private static String joining_1()
    {
        return StudentDatabase.getAllStudents() //List<Student>
                .stream()   //Stream<Student>
                .map(Student::getName)  //Stream<String>
                .collect(joining());
    }
    
    // with demiliter ','
    private static String joining_2()
    {
        return StudentDatabase.getAllStudents() //List<Student>
                .stream()   //Stream<Student>
                .map(Student::getName)  //Stream<String>
                .collect(joining(","));
    }
    
    // with demiliter ',', prefix '('  and suffix ')'
    private static String joining_3()
    {
        return StudentDatabase.getAllStudents() //List<Student>
                .stream()   //Stream<Student>
                .map(Student::getName)  //Stream<String>
                .collect(joining(",", "(", ")"));
    }
}
