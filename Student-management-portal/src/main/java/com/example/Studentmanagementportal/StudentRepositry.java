package com.example.Studentmanagementportal;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class StudentRepositry {
    HashMap<Integer, student> studentdb = new HashMap<>();

    public student getStudent(int admnNo) {
        return studentdb.get(admnNo);
    }

    public String addStudent(student student) {
        int admnNo=student.getAdmission_no();
        if(studentdb.containsKey(admnNo)) {
            return "student is already present ";
        }
        studentdb.put(admnNo, student);
        return "Student is added successfully ";
    }

    public student getStudentByPathVariable(int admnNo) {
        return studentdb.get(admnNo);
    }

    public String  deleteFromDatabase(int admnNo) {
        if(studentdb.containsKey(admnNo)) {
            studentdb.remove(admnNo);
            return "student Deleted successfully ";
        } else {
            throw new RuntimeException("This admnNo doesn't exist please enter valid admnNo");
        }
    }

    public student updateInDatabase(int admnNo, String newCourse) {
        if (studentdb.containsKey(admnNo) == false) {
            throw new RuntimeException("student doesn't exist");
        } else {
            student st = studentdb.get(admnNo);
            st.setCourse(newCourse);
            return st;
        }
    }

    public int CountTotalStudent() {
        int count=0;
        for(int k: studentdb.keySet()) {
            student st=studentdb.get(k);
            int ages=st.getAge();
            if(ages>20) count++;
        }
        return count;
    }
}
