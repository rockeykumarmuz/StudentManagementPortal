package com.example.Studentmanagementportal;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    // Logger is a inbuilt class name it gives log
    public static Logger logger = LoggerFactory.getLogger(StudentController.class);
    @GetMapping("/get_info")
    // request parameter in APIs
    public ResponseEntity getStudent(@RequestParam("id") int admnNo) {
        student s= studentService.getStudent(admnNo);
        if(s==null) {
            return new ResponseEntity("Key is not exist ", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(s, HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    // ResponseEntity is inbuilt class in java in  which first entity is content then httpStatus code
    public ResponseEntity addStudent(@RequestBody student student) {

        logger.trace(String.valueOf(student));
        logger.debug("This is a DEBUG log");
        logger.info("This is a INFO log");
        logger.warn("This is a WARN log");
        logger.error("This is a ERROR log");
        logger.trace("This is a TRACE log");

        String s=studentService.addStudent(student);
        return new ResponseEntity(s, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}/{message}")
    public String getStudentByPathVariable(@PathVariable("id") int admnNo, @PathVariable("message") String message) {
        return studentService.getStudentByPathVariable(admnNo, message);
    }

    // delete a students by admission_no
    @DeleteMapping("/delete")
    public ResponseEntity deleteFromDatabase(@RequestParam("id") int admnNo) {
           String ans=studentService.deleteFromDatabase(admnNo);
           return new ResponseEntity(ans, HttpStatus.METHOD_NOT_ALLOWED);
    }

    //update a course based on student admnNo
    @PutMapping("/update_course")
    public ResponseEntity updateInDatabase(@RequestParam("id") int admnNo, @RequestParam("course") String newCourse) {
        student s= studentService.updateInDatabase(admnNo, newCourse);
        return new ResponseEntity(s, HttpStatus.BAD_GATEWAY);
    }

    // count total no of students whose age is grater than 25
    @GetMapping("/totalStudentWhoseAgeIsGreaterThan_20")
    public ResponseEntity CountTotalStudent() {
        int ans= studentService.CountTotalStudent();
        return new ResponseEntity(ans, HttpStatus.NO_CONTENT);
    }
}
