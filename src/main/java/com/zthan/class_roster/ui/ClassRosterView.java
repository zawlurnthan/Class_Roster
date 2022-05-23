/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zthan.class_roster.ui;

import com.zthan.class_roster.dto.Student;
import java.util.List;

/**
 *
 * @author Zaw L Than
 */
public class ClassRosterView {
    
    private final UserIO io;
    
    public ClassRosterView(UserIO io) {
        this.io = io;
    }
    
    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Student IDs");
        io.print("2. Create New Student");
        io.print("3. View a Student");
        io.print("4. Remove a Student");
        io.print("5. Exit");
            
        return io.readInt("Please select from the above choices.", 1, 5);
    }
    
    public Student getNewStudentInfo() {
        String id = io.readString("Please enter student ID");
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name");
        String cohort = io.readString("Please enter Cohort");
        
        Student student = new Student(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setCohort(cohort);
        return student;
    }
    
    public void displayCreatedStudentBanner() {
        io.print("=== Create Student ===");
    }
    
    public void displayCreatedSuccessBanner() {
        io.readString("Student successfully created. Please hit enter to continue.");
    }
    
    public void displayStudentList(List<Student> studentList) {
        for (Student currentStudent : studentList) {
            String studentInfo = String.format("#%s : %s %s",
                    currentStudent.getStudentId(),
                    currentStudent.getFirstName(),
                    currentStudent.getLastName());
            io.print(studentInfo);
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayAllStudentsBanner() {
        io.print("=== Display all Students ===");
    }
    
    public void displayStudentBanner() {
        io.print("=== Display Student ===");
    }
    
    public String getStudentIdChoice() {
        return io.readString("Please enter the Student ID.");
    }
    
    public void displayStudent(Student student) {
        if (student != null) {
            io.print(student.getStudentId());
            io.print(student.getFirstName() + " " + student.getLastName());
            io.print(student.getCohort());
            io.print("");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ===");
    }
    
    public void displayRemoveResult(Student student) {
        if (student != null) {
            io.print("Student successfully removed.");
        } else {
            io.print("No such student.");
        }
        io.readString("Please hit enter to continue.");
    }
    
    public void displayExitBanner() {
        io.print("Good Bye!");
    }
    
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print("errorMsg");
    }
}
