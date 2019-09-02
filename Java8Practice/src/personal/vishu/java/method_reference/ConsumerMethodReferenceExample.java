package personal.vishu.java.method_reference;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

    private static List<Student> studentList = StudentDatabase.getAllStudents();

    private static Consumer<Student> studentConsumer = System.out::println;
    private static Consumer<Student> studentActivitiesListConsumer = Student::printListOfActivities;

    public static void main(String[] args) {
        System.out.println("Student List : ");
        studentList.forEach(studentConsumer);
        System.out.println("\nActivities List : ");
        studentList.forEach(studentActivitiesListConsumer);
    }
}
