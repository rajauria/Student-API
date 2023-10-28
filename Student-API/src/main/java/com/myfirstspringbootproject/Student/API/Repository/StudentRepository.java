package com.myfirstspringbootproject.Student.API.Repository;

import com.myfirstspringbootproject.Student.API.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String, Student> studentDB;

    public StudentRepository() {
        this.studentDB = new HashMap<>();
        studentDB.put("Student1", new Student("Himanshu", "Student1",6, 75,10,"Bangalore",23));
        studentDB.put("Student2", new Student("Nakul", "Student2",6, 75,6,"Bangalore",23));
        studentDB.put("Student3", new Student("Heena", "Student3",6, 75,9,"Bangalore",23));
    }

    public Student getStudentDetailsByID (String studentID){
        return studentDB.get (studentID);
    }

    public List<Student> getAllStudents (){
        List <Student> allStudents = new ArrayList<>();
        for (String key : studentDB.keySet()){
            allStudents.add (studentDB.get(key));
        }
        return allStudents;
    }

    public void addStudent (Student obj){
        String studentID = obj.getId();
        studentDB.put (studentID,obj);
    }
}
