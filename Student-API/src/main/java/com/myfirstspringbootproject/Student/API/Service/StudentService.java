package com.myfirstspringbootproject.Student.API.Service;

import com.myfirstspringbootproject.Student.API.Model.Student;
import com.myfirstspringbootproject.Student.API.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
     StudentRepository studentRepo = new StudentRepository();

     public int calculateBMI (String studentID){
          Student obj = studentRepo.getStudentDetailsByID(studentID);
          int age = obj.getAge();
          int height = obj.getHeight();
          int weight = obj.getWeight();
          int bmi = weight / (height * height);
          return bmi;
     }

     public Student maxAptiStudent (){
          List<Student> allStudents = studentRepo.getAllStudents();

          int max = Integer.MIN_VALUE;
          Student obj = null;

          for (Student s : allStudents){
               if (max < s.getAptitude()){
                    max = s.getAptitude();
                    obj = s;
               }
          }
          return obj;
     }

     public List<Student> getAllStudents (){
          return studentRepo.getAllStudents();
     }

     public void addStudent (Student obj){
          studentRepo.addStudent(obj);
     }

}
