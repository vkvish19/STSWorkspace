package personal.vishu.java.streams;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class StreamsMapExample {

    public static List<String> studentNamesList() {
        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                // input -> Student, output -> Student Name
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<String> - uppercase operation on each input
                .collect(toList()); //List<String>
    }

    public static Set<String> studentNamesSet() {
        return StudentDatabase.getAllStudents().stream() // Stream<Student>
                // input -> Student, output -> Student Name
                .map(Student::getName) // Stream<String>
                .map(String::toUpperCase) // Stream<String> - uppercase operation on each input
                .collect(toSet()); // Set<String>
    }

    public static void main(String[] args) {
        System.out.println("Student List : " + studentNamesList());
        System.out.println("Student Set : " + studentNamesSet());
    }
}
