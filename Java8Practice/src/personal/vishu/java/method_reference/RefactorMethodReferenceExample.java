package personal.vishu.java.method_reference;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

import java.util.function.Predicate;

public class RefactorMethodReferenceExample {

    static Predicate<Student> studentPredicate = RefactorMethodReferenceExample::greaterThanGradeLevel;

    public static boolean greaterThanGradeLevel(Student student) {
        return student.getGradeLevel() >= 3;
    }

    public static void main(String[] args) {
        System.out.println(studentPredicate.test(StudentDatabase.studentSupplier.get()));
    }
}
