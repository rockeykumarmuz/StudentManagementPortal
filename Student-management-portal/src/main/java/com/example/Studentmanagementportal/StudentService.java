package com.example.Studentmanagementportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepositry studentRepositry;

    // it is a database logic so it should be in repositry class
    public student getStudent(int admnNo) {
        return studentRepositry.getStudent(admnNo);
    }

    public String addStudent(student student) {
        return studentRepositry.addStudent(student);
    }

    public String getStudentByPathVariable(int admnNo, String message) {
        return studentRepositry.getStudentByPathVariable(admnNo) + message;
    }

    public String deleteFromDatabase(int admnNo) {
        return studentRepositry.deleteFromDatabase(admnNo);
    }

    public student updateInDatabase(int admnNo, String newCourse) {
        return studentRepositry.updateInDatabase(admnNo, newCourse);
    }

    public int CountTotalStudent() {
        return studentRepositry.CountTotalStudent();
    }
}
