package personal.vishu.java.streams;

import personal.vishu.java.data.StudentDatabase;

public class StreamsMatchExample
{
    public static void main(String[] args)
    {
        System.out.println("Do all Students have GPA >= 3.9 ?  ==> " + allMatch());
        System.out.println("Is there any Student with name as 'Emily' ? ==> " + anyMatch());
        System.out.println("Do all Student have gradeLevel < 5 ? ==> " + noneMatch());
    }
    
    private static boolean allMatch()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .allMatch(student -> student.getGpa() >= 3.9);
    }
    
    private static boolean anyMatch()
    {
        return StudentDatabase.getAllStudents()
                .stream()
                .anyMatch(student -> student.getName().equalsIgnoreCase("emily"));
    }
    
    private static boolean noneMatch()
    {
        // this checks if any student has gradeLevel >= 5
        // returns true -> if no student has gradeLevel >= 5
        // returns false -> if any student has gradeLevel >= 5
        return StudentDatabase.getAllStudents()
                .stream()
                .noneMatch(student -> student.getGradeLevel() >= 5);
    }
}
