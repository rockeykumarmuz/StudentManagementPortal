package com.example.Studentmanagementportal;

public class student {
    private int admission_no; // this is act aa a primary key
    private String name;
    private String course;
    private int age;

    public void Student(){
    }

    public int getAdmission_no() {
        return admission_no;
    }

    public void setAdmission_no(int admission_no) {
        this.admission_no = admission_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "admission_no=" + admission_no +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", age=" + age +
                '}';
    }
}
