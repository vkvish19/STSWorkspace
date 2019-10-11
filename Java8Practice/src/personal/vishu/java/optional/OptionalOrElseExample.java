package personal.vishu.java.optional;

import java.util.Optional;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class OptionalOrElseExample
{
    public static void main(String[] args)
    {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
        System.out.println("optionalOrElse(studentOptional) = " + optionalOrElse(studentOptional));
        System.out.println("optionalOrElseGet(studentOptional) = " + optionalOrElseGet(studentOptional));
        System.out.println("optionalOrElseThrow(studentOptional) = " + optionalOrElseThrow(studentOptional));
        
        Optional<Student> studentOptional1 = Optional.ofNullable(null);
        System.out.println("optionalOrElse(studentOptional1) = " + optionalOrElse(studentOptional1));
        System.out.println("optionalOrElseGet(studentOptional1) = " + optionalOrElseGet(studentOptional1));
        System.out.println("optionalOrElseThrow(studentOptional1) = " + optionalOrElseThrow(studentOptional1));
    }
    
    private static String optionalOrElse(Optional<Student> studentOptional)
    {
        return studentOptional.map(Student::getName).orElse("Default_Name");
    }
    
    private static String optionalOrElseGet(Optional<Student> studentOptional)
    {
        return studentOptional.map(Student::getName).orElseGet( () -> "Default_Name");
    }
    
    private static String optionalOrElseThrow(Optional<Student> studentOptional)
    {
        return studentOptional.map(Student::getName).orElseThrow( () -> new RuntimeException("No Data Available..."));
    }
}
