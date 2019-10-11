package personal.vishu.java.defaults;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class DefaultMethodsExample2
{
    private static Consumer<Student> studentConsumer = System.out::println;
    private static Comparator<Student> studentNameComparator = Comparator.comparing(Student::getName);
    private static Comparator<Student> studentGpaComparator = Comparator.comparingDouble(Student::getGpa);
    private static Comparator<Student> studentGradeLevelComaparator = Comparator.comparing(Student::getGradeLevel);
    
    public static void main(String[] args)
    {
        List<Student> studentList = StudentDatabase.getAllStudents();
//        System.out.println(studentList);
        System.out.println("Student List before any kind of sorting : ");
        studentList.forEach(studentConsumer);
        
//        sortByStudentName(studentList);
//        sortByStudentGpa(studentList);
//        comparatorChaining(studentList);
        sortWithNullValuesAtFirst(studentList);
        sortWithNullValuesAtLast(studentList);
    }
    
    private static void sortByStudentName(List<Student> studentList)
    {
        studentList.sort(studentNameComparator);
    
        System.out.println("\nStudent List after sorting by Student Name : ");
        studentList.forEach(studentConsumer);
    }
    
    private static void sortByStudentGpa(List<Student> studentList)
    {
        studentList.sort(studentGpaComparator);
        
        System.out.println("\nStudent List after sorting by Student GPA : ");
        studentList.forEach(studentConsumer);
    }
    
    private static void comparatorChaining(List<Student> studentList)
    {
        studentList.sort(studentGradeLevelComaparator.thenComparing(studentGpaComparator).thenComparing(studentNameComparator));
    
        System.out.println("\nStudent List after Comparator Chaining : ");
        studentList.forEach(studentConsumer);
    }
    
    /**
     * to handle cases where the list contains null
     * @param studentList
     */
    private static void sortWithNullValuesAtFirst(List<Student> studentList)
    {
        Comparator<Student> studentComparator = Comparator.nullsFirst(studentNameComparator);
        studentList.sort(studentComparator);
        System.out.println("\nStudent list after sortWithNullValuesAtFirst : ");
        studentList.forEach(studentConsumer);
    }
    
    /**
     * to handle cases where the list contains null
     * @param studentList
     */
    private static void sortWithNullValuesAtLast(List<Student> studentList)
    {
        Comparator<Student> studentComparator = Comparator.nullsLast(studentGpaComparator);
        studentList.sort(studentComparator);
        System.out.println("\nStudent list after sortWithNullValuesAtLast : ");
        studentList.forEach(studentConsumer);
    }
}
