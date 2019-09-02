package personal.vishu.java.streams;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    static Predicate<Student> studentPredicateByGradeLevel = student -> student.getGradeLevel() >= 3;
    static Predicate<Student> studentPredicateByGpa = student -> student.getGpa() >= 3.9;

    public static void main(String[] args) {
        Map<String, List<String>> studentNameAndActivitiesMap =
                StudentDatabase.getAllStudents()
                        .stream()
                        .peek(System.out::println)
                        .filter(studentPredicateByGradeLevel)   //this is intermediate operation and it returns Stream<Student>
                        .peek(student -> System.out.println("after 1st filter: " + student))
                        .filter(studentPredicateByGpa)  //this is intermediate operation and it returns Stream<Student>
                        .peek(student -> System.out.println("after 2nd filter: " + student))
                        .collect(Collectors.toMap(Student::getName, Student::getActivities)); // this is terminal operation and it returns <Map>

        System.out.println(studentNameAndActivitiesMap);
        System.out.println("Map size : " + studentNameAndActivitiesMap.size());
    }
}
