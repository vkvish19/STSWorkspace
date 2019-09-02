package personal.vishu.java.functional_interfaces;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerExample {

    private static List<Student> studentList = StudentDatabase.getAllStudents();
    private static BiConsumer<String, List<String>> studentNameAndActivities =
            (name, activities) -> System.out.println(name + " : " + activities);

    public static void main(String[] args) {
        BiConsumer<String, String> biConsumer1 = (a, b) -> System.out.println("a: " + a + ", b: " + b);
        biConsumer1.accept("this too", "shall pass");

        BiConsumer<Integer, Integer> multiply = (a, b) -> System.out.println(String.format("Product of %d and %d is: %d", a, b, (a * b)));
        BiConsumer<Integer, Integer> division = (a, b) -> System.out.println(String.format("Division of %d by %d is: %d", a, b, (a / b)));
        multiply.andThen(division).accept(10, 5);

        printStudentNameAndActivities();
    }

    public static void printStudentNameAndActivities() {
        System.out.println("Result in printStudentNameAndActivities() ::");

        studentList.forEach(student -> studentNameAndActivities.accept(student.getName(), student.getActivities()));

    }
}