package personal.vishu.java.functional_interfaces;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {

    private static List<Student> studentList = StudentDatabase.getAllStudents();

    private static Function<List<Student>, Map<String, Double>> functionStudentNameGpaMap = students -> {
        Map<String, Double> studentNameGpaMap = new HashMap<>();
        students.forEach(student -> {
            if (PredicateStudentExample.studentByGradeLevel.test(student))
                studentNameGpaMap.put(student.getName(), student.getGpa());
        });

        return studentNameGpaMap;
    };

    public static void main(String[] args) {
        System.out.println(functionStudentNameGpaMap.apply(studentList));
    }
}
