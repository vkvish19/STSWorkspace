package personal.vishu.java.streams.terminal_streams;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toSet;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class StreamsGroupingByExample
{
    public static void main(String[] args)
    {
        System.out.println("groupingByGender() = " + groupingByGender());
        System.out.println("customizedGroupingBy() = " + customizedGroupingBy());
        System.out.println("twoLevelGrouping_1() = " + twoLevelGrouping_1());
        System.out.println("twoLevelGrouping_2() = " + twoLevelGrouping_2());
        System.out.println("threeLevelGrouping() = " + threeLevelGrouping());
        System.out.println("calculateTopGpaStudentPerGradeLevel() = " + calculateTopGpaStudentPerGradeLevel());
        System.out.println("calculateTopGpaStudentPerGradeLevelWithoutOptionalWrapping() = " + calculateTopGpaStudentPerGradeLevelWithoutOptionalWrapping());
        System.out.println("calculateLeastGpaStudentPerGradeLevel() = " + calculateLeastGpaStudentPerGradeLevel());
        System.out.println("calculateLeastGpaStudentPerGradeLevelWithoutOptionalWrapping() = " + calculateLeastGpaStudentPerGradeLevelWithoutOptionalWrapping());
    }
    
    private static Map<String,List<Student>> groupingByGender()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));
    }
    
    private static Map<String, List<Student>> customizedGroupingBy()
    {
         return StudentDatabase.getAllStudents()
                .stream()
                .collect(groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"));
    }
    
    private static Map<Integer, Map<String, List<Student>>> twoLevelGrouping_1()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(
                        groupingBy(Student::getGradeLevel, groupingBy(student -> student.getGpa() >= 3.8 ? "OUTSTANDING" : "AVERAGE"))
                        );
    }
    
    private static Map<Integer,Integer> twoLevelGrouping_2()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(
                        groupingBy(Student::getGradeLevel, summingInt(Student::getNotebooks))
                        );
    }
    
    private static LinkedHashMap<String,Set<Student>> threeLevelGrouping()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(
                        groupingBy(Student::getName, LinkedHashMap::new, toSet())
                        );
    }
    
    // this returns the Map with value having Student wrapped in Optional
    private static Map<Integer,Optional<Student>> calculateTopGpaStudentPerGradeLevel()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(
                        groupingBy(Student::getGradeLevel, maxBy(Comparator.comparing(Student::getGpa)))
                        );
    }
    
    // this returns the Map with value having Student without Optional wrapping
    private static Map<Integer, Student> calculateTopGpaStudentPerGradeLevelWithoutOptionalWrapping()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(
                        groupingBy(Student::getGradeLevel,
                                collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)), Optional::get)
                        )
                );
    }
    
    // this returns the Map with value having Student wrapped in Optional
    private static Map<Integer,Optional<Student>> calculateLeastGpaStudentPerGradeLevel()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(
                        groupingBy(Student::getGradeLevel, minBy(Comparator.comparing(Student::getGpa)))
                );
    }
    
    // this returns the Map with value having Student without Optional wrapping
    private static Map<Integer, Student> calculateLeastGpaStudentPerGradeLevelWithoutOptionalWrapping()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .collect(
                        groupingBy(Student::getGradeLevel,
                                collectingAndThen(minBy(Comparator.comparing(Student::getGpa)), Optional::get)
                        )
                );
    }

}
