package personal.vishu.java.streams;

import java.util.Optional;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class StreamsFindFirstFindAnyExample
{
    //Difference between anyMatch(), allMatch(), noneMatch() and findAny(), findFirst() is that,
    // anyMatch(), allMatch(), noneMatch() -> return boolean.
    // findAny(), findFirst() -> return element.
    
    
    
    public static void main(String[] args)
    {
        Optional<Student> studentOptionalFindAny = findAnyStudent();
        if(studentOptionalFindAny.isPresent())
            System.out.println("Found Student : " + studentOptionalFindAny.get());
        else
            System.out.println("[findAny()] No student found matching the criteria");
    
        Optional<Student> studentOptionalFindFirst = findFirstStudent();
        if(studentOptionalFindFirst.isPresent())
            System.out.println("Found Student : " + studentOptionalFindFirst.get());
        else
            System.out.println("[findFirst()] No student found matching the criteria");
    }
    
    private static Optional<Student> findAnyStudent()
    {
        //returns the first encountered element in the stream that matches the filter criteria.
        // NOTE: the exact difference of this with findFirst can be understood during parallelStream
        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findAny();
    }
    
    private static Optional<Student> findFirstStudent()
    {
        //returns the first element in the stream that matches the criteria.
        // NOTE: the exact difference of this with findAny can be understood during parallelStream
        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findFirst();
    }
}
