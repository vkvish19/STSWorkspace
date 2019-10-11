package personal.vishu.java.streams;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class StreamsMapReduceExample
{
    public static void main(String[] args)
    {
        System.out.println("totalNumberOfNoteBooks() = " + totalNumberOfNoteBooks());
        System.out.println("totalNumberOfNoteBooksWithMaleStudents = " + totalNumberOfNoteBooksGenderWise("male"));
        System.out.println("totalNumberOfNoteBooksWithFemaleStudents = " + totalNumberOfNoteBooksGenderWise("female"));
    }
    
    private static int totalNumberOfNoteBooks()
    {
        return StudentDatabase.getAllStudents()
                .stream()   //Stream<Student>
                .map(Student::getNotebooks) //Stream<Integer>
//                .reduce(0, (a, b) -> a+b);
                .reduce(0, Integer::sum);
    }
    
    private static int totalNumberOfNoteBooksGenderWise(String gender)
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .filter(student -> student.getGender().equalsIgnoreCase(gender))
                .map(Student::getNotebooks)
                .reduce(0, Integer::sum);
    }
}
