package personal.vishu.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class StreamsReduceExample
{
    public static void main(String[] args)
    {
        List<Integer> integerList = Arrays.asList(1, 3, 5, 7, 9);
    
        System.out.println("performMultiplication(integerList) = " + performMultiplication(integerList));
        
        Optional<Integer> result = performMultiplicationWithoutIdentity(integerList);
        System.out.println("result.isPresent() = " + result.isPresent());
        System.out.println("result.get() = " + result.get());
    
        List<Integer> integerEmptyList = new ArrayList<>();
        Optional<Integer> result1 = performMultiplicationWithoutIdentity(integerEmptyList);
        if(result1.isPresent())
            System.out.println("result1.get() = " + result1.get());
        else
            System.out.println("result1 is empty");
        
        Optional<Student> femaleStudentWithHighestGpa = getHighestGpaFemaleStudent();
        if(femaleStudentWithHighestGpa.isPresent())
            System.out.println("femaleStudentWithHighestGpa = " + femaleStudentWithHighestGpa.get());
    }
    
    private static int performMultiplication(List<Integer> integerList)
    {
        return integerList
                .stream()
                .reduce(1, (a,b) -> a*b);
    }
    
    private static Optional<Integer> performMultiplicationWithoutIdentity(List<Integer> integerList)
    {
        return integerList
                .stream()
                .reduce((a,b) -> a*b);
    }
    
    public static Optional<Student> getHighestGpaFemaleStudent()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGender().equalsIgnoreCase("female"))
                .reduce((s1, s2) -> s1.getGpa() > s2.getGpa() ? s1 : s2);
    }
}
