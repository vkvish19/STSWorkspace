package personal.vishu.java.functional_interfaces;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class BiFunctionExample {

    private static List<Student> studentList = StudentDatabase.getAllStudents();

    private static BiFunction<List<Student>, Predicate<Student>, Map<String, Double>> biFunctionStudentNameGpaMap =
            (students, studentPredicate) -> {
                Map<String, Double> studentNameGpaMap = new HashMap<>();
                students.forEach(student -> {
                    if(studentPredicate.test(student))
                        studentNameGpaMap.put(student.getName(), student.getGpa());
                });

                return studentNameGpaMap;
            };

    public static void main(String[] args) {
        System.out.println("Result with grade level predicate : "
                + biFunctionStudentNameGpaMap.apply(studentList, PredicateStudentExample.studentByGradeLevel));

        System.out.println("Result with gpa predicate : "
                + biFunctionStudentNameGpaMap.apply(studentList, PredicateStudentExample.studentByGpa));
    }
}
