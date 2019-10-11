package personal.vishu.java.streams.terminal_streams;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Set;

import personal.vishu.java.data.Student;
import personal.vishu.java.data.StudentDatabase;

public class StreamsMappingExample
{
    public static void main(String[] args)
    {
        List<String> namesList = StudentDatabase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName, toList()));
    
        System.out.println("namesList = " + namesList);
    
        Set<String> namesSet = StudentDatabase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName, toSet()));
    
        System.out.println("namesSet = " + namesSet);
    }
}
