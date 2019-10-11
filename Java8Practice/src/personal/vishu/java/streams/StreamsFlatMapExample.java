package personal.vishu.java.streams;

import static java.util.stream.Collectors.toList;

import java.util.List;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class StreamsFlatMapExample
{
    public static void main(String[] args)
    {
        System.out.println("getStudentActivities() = " + getStudentActivities());
        System.out.println("getStudentDistinctActivitiesCount() = " + getStudentDistinctActivitiesCount());
        System.out.println("getStudentActivitiesCount() = " + getStudentActivitiesCount());
    }
    
    private static List<String> getStudentActivities()
    {
        return StudentDatabase.getAllStudents().stream()   //Stream<Student>
                .map(Student::getActivities)    //Stream<List<String>>
                .flatMap(List::stream)  //Stream<String>
                .distinct() //Stream<String> - gives the distinct values (as the name suggests)
                .sorted()   //Stream<String> - sorted in Alphabetical order
                .collect(toList());
    }
    
    private static long getStudentDistinctActivitiesCount()
    {
        return StudentDatabase.getAllStudents().stream()   //Stream<Student>
                .map(Student::getActivities)    //Stream<List<String>>
                .flatMap(List::stream)  //Stream<String>
                .distinct() //Stream<String> - gives the distinct values (as the name suggests)
                .count();
    }
    
    private static long getStudentActivitiesCount()
    {
        return StudentDatabase.getAllStudents().stream()   //Stream<Student>
                .map(Student::getActivities)    //Stream<List<String>>
                .flatMap(List::stream)  //Stream<String>
                .count();
    }
}
