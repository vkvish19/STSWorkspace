package personal.vishu.java.functional_interfaces;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

import java.util.List;
import java.util.function.Predicate;

public class PredicateStudentExample {

    private static List<Student> studentList = StudentDatabase.getAllStudents();
    static Predicate<Student> studentByGradeLevel = student -> student.getGradeLevel()>=3;
    static Predicate<Student> studentByGpa = student -> student.getGpa()>=3.9;

    public static void main(String[] args) {
        getStudentsByGradeLevel();
        getStudentsByGpa();
        getStudentsByGradeLevelAndGpa();
        getStudentsByGradeLevelOrGpa();
        getNegateOfStudentsByGradeLevelAndGpa();
    }

    public static void getStudentsByGradeLevel() {
        System.out.println("getStudentsByGradeLevel ::");
        studentList.forEach(student -> {
            if (studentByGradeLevel.test(student))
                System.out.println(student);
        });
    }

    public static void getStudentsByGpa() {
        System.out.println("getStudentsByGpa ::");
        studentList.forEach(student -> {
            if (studentByGpa.test(student))
                System.out.println(student);
        });
    }

    public static void getStudentsByGradeLevelAndGpa() {
        System.out.println("getStudentsByGradeLevelAndGpa ::");
        studentList.forEach(student -> {
            if (studentByGradeLevel.and(studentByGpa).test(student))
                System.out.println(student);
        });
    }

    public static void getStudentsByGradeLevelOrGpa() {
        System.out.println("getStudentsByGradeLevelOrGpa ::");
        studentList.forEach(student -> {
            if (studentByGradeLevel.or(studentByGpa).test(student))
                System.out.println(student);
        });
    }

    public static void getNegateOfStudentsByGradeLevelAndGpa() {
        System.out.println("getNegateOfStudentsByGradeLevelAndGpa ::");
        studentList.forEach(student -> {
            if (studentByGradeLevel.and(studentByGpa).negate().test(student))
                System.out.println("INSIDE IF : " + student);
            else
                System.out.println("INSIDE ELSE : " + student);
        });
    }
}
