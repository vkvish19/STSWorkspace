package personal.vishu.java.optional;

import java.util.Optional;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class OptionalExample
{
    public static void main(String[] args)
    {
        Optional<String> stringOptional = getStudentNameUsingOptional();
        
        if(stringOptional.isPresent())
            System.out.println("Length of the student name '" +stringOptional.get() + "': " + stringOptional.get().length());
        else
            System.out.println("No name found");
    }
    
    private static Optional<String> getStudentNameUsingOptional()
    {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
//        Optional<Student> studentOptional = Optional.ofNullable(null);
        if(studentOptional.isPresent())
            return studentOptional.map(Student::getName);
        
        return Optional.empty();    // represents an optional object with no value
    }
}
