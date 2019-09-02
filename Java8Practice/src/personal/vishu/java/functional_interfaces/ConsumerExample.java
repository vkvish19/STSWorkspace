package personal.vishu.java.functional_interfaces;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    private static List<Student> studentList = StudentDatabase.getAllStudents();

    static Consumer<String> consumer1 = s -> System.out.println(s.toUpperCase());
    static Consumer<Student> consumer2 = student -> System.out.println(student);
    static Consumer<Student> consumer3 = student -> System.out.print(student.getName() +": ");
    static Consumer<Student> consumer4 = student -> System.out.println(student.getActivities());

    public static void main(String[] args) {
        consumer1.accept("this too shall pass");

        printStudents();
        printStudentNameAndActivities();
        printStudentNameAndActivitiesUsingCondition();
    }

    public static void printStudents() {
        System.out.println("Result in printStudents() ::");

        studentList.forEach(consumer2);
    }

    public static void printStudentNameAndActivities() {
        System.out.println("Result in printStudentNameAndActivities() ::");

        //consumer chaining
        studentList.forEach(consumer3.andThen(consumer4));
    }

    public static void printStudentNameAndActivitiesUsingCondition() {
        System.out.println("Result in printStudentNameAndActivitiesUsingCondition() ::");
        studentList.forEach(student -> {
            if( (student.getGradeLevel() >= 3) && (student.getGpa() >= 3.9) )
                consumer3.andThen(consumer4).accept(student);
        });
    }
}
