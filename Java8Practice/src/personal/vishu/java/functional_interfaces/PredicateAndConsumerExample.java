package personal.vishu.java.functional_interfaces;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateAndConsumerExample {

    Predicate<Student> studentByGradeLevel = student -> student.getGradeLevel() >= 3;
    Predicate<Student> studentByGpa = student -> student.getGpa() >= 3.9;

    BiPredicate<Integer, Double> biPredicateStudentByGradeLevelAndGpa =
            (gradeLevel, gpa) -> (gradeLevel >= 3) && (gpa >= 3.9);

    BiConsumer<String, List<String>> studentNameAndActivities =
            (name, activities) -> System.out.println(name + " : " + activities);

    Consumer<Student> studentConsumer = student -> {
//        if(studentByGradeLevel.and(studentByGpa).test(student))
        if(biPredicateStudentByGradeLevelAndGpa.test(student.getGradeLevel(), student.getGpa()))
            studentNameAndActivities.accept(student.getName(), student.getActivities());
    };

    public void printStudentNameAndActivities(List<Student> students) {
        students.forEach(studentConsumer);
    }

    public static void main(String[] args) {
        List<Student> studentList = StudentDatabase.getAllStudents();
        new PredicateAndConsumerExample().printStudentNameAndActivities(studentList);
    }
}
