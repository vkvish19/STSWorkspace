package personal.vishu.java.optional;

import java.util.Optional;

import personal.vishu.java.data.Bike;
import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class OptionalMapFlatMapExample
{
    private static Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());

    public static void main(String[] args)
    {
        optionalFilter();
        optionalMap();
        optioanlFlatMap();
    }
    
    private static void optionalFilter()
    {
        studentOptional
                .filter(student -> student.getGpa() >= 3.5)
                .ifPresent(student -> System.out.println("student = " + student));
    }
    
    private static void optionalMap()
    {
        Optional<String> stringOptional = studentOptional
                .filter(student -> student.getGpa() >= 3.5)
                .map(Student::getName);
        
        stringOptional.ifPresent( s -> System.out.println("student name = " + stringOptional.get()) );
        
    }
    
    private static void optioanlFlatMap()
    {
        Optional<String> bikeName = studentOptional
                .filter(student -> student.getGpa() >= 3.5)
                .flatMap(Student::getBike)
                .map(Bike::getName);
        
        bikeName.ifPresent( name -> System.out.println("Bike Name = " + name));
    }
}
