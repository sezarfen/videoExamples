package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.Entities.Student;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Student Name");

        ObjectMapper objectMapper = new ObjectMapper();

        try{
            String mappedObject = objectMapper.writeValueAsString(student);
            Student newStudent = objectMapper.readValue(mappedObject, Student.class);
        }
        catch (com.fasterxml.jackson.core.JsonProcessingException exc){
            exc.printStackTrace();
        }


    }
}