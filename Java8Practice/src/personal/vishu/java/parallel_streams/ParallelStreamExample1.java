package personal.vishu.java.parallel_streams;

import static java.util.stream.Collectors.toList;

import java.util.List;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class ParallelStreamExample1
{
    public static void main(String[] args)
    {
        System.out.println("Number of processors in the machine : " + Runtime.getRuntime().availableProcessors());
        sequentialGetStudentActivities();
        parallelGetStudentActivities();
    }
    
    private static List<String> sequentialGetStudentActivities()
    {
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDatabase.getAllStudents()
                .stream()   //Stream<Student>
                .map(Student::getActivities)    //Stream<List<String>>
                .flatMap(List::stream)  //Stream<String>
                .distinct() //Stream<String> - gives the distinct values (as the name suggests)
                .sorted()   //Stream<String> - sorted in Alphabetical order
                .collect(toList());
        long endTime = System.currentTimeMillis();
    
        System.out.println("Time taken to execute the pipeline sequentially : " + (endTime - startTime));
        
        return studentActivities;
    }
    
    private static List<String> parallelGetStudentActivities()
    {
        long startTime = System.currentTimeMillis();
        List<String> studentActivities = StudentDatabase.getAllStudents()
                .stream()   //Stream<Student>
                .parallel()
                .map(Student::getActivities)    //Stream<List<String>>
                .flatMap(List::stream)  //Stream<String>
                .distinct() //Stream<String> - gives the distinct values (as the name suggests)
                .sorted()   //Stream<String> - sorted in Alphabetical order
                .collect(toList());
        long endTime = System.currentTimeMillis();
    
        System.out.println("Time taken to execute the pipeline sequentially : " + (endTime - startTime));
        return studentActivities;
    }
}
