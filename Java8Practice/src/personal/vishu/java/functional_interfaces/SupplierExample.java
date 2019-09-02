package personal.vishu.java.functional_interfaces;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    private static Supplier<Student> studentSupplier =
            () -> new Student("Emily",3,4.0,"female",
                    Arrays.asList("swimming", "gymnastics","aerobics"));

    private static Supplier<List<Student>> studentListSupplier = StudentDatabase::getAllStudents;

    public static void main(String[] args) {
        System.out.println("Student is : " + studentSupplier.get());

        System.out.println("Student List is : " + studentListSupplier.get());
    }
}
