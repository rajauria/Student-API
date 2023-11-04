package com.myfirstspringbootproject.Student.API.Controller;

import com.myfirstspringbootproject.Student.API.Model.Student;
import com.myfirstspringbootproject.Student.API.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    StudentService studentService = new StudentService();
    @RequestMapping ("/api/getallstudents")
    @GetMapping
    public List<Student> getAllStudents (){
         return studentService.getAllStudents();
    }

    @RequestMapping ("/api/getmaxaptitude")
    @GetMapping
    public Student getMaxAptitude (){
        return  studentService.maxAptiStudent();
    }

    @RequestMapping ("/api/addstudent")
    @PostMapping
    public String addStudent (@RequestBody Student obj){
        studentService.addStudent(obj);
        return "Hey student got inserted successfully";
    }
    @RequestMapping ("/api/getbmi")
    @GetMapping
    public int getBMI (@RequestParam String studentID){
        return studentService.calculateBMI(studentID);
    }

    @PutMapping ("/api/update/{studentID}/alldetails")
    public String updateAllDetails (@PathVariable String studentID , @RequestBody Student obj){
        studentService.updateAllDetailsbyID(studentID,obj);
        return "All Details of student got updated with student id as " + studentID;
    }

    @DeleteMapping ("/api/delete/student/{studentID}")
        public String deleteStudentByID (@PathVariable String studentID) {
        studentService.deleteStudentByID(studentID);
        return studentID + " got deleted from the database";
    }
}

