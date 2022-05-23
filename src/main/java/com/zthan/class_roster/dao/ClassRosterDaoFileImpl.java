/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zthan.class_roster.dao;

import com.zthan.class_roster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Zaw L Than
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {
    
    private Map<String, Student> students = new HashMap<>();
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    @Override
    public Student addStudent(String id, Student student) throws ClassRosterDaoException {
        loadRoster();
        Student newStudent = students.put(id, student);
        writeRoster();
        return newStudent;
    }

    /**
     *
     * @return
     * @throws ClassRosterDaoException
     */
    @Override
    public List<Student> getAllStudents() throws ClassRosterDaoException {
        loadRoster();
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String id) throws ClassRosterDaoException {
        loadRoster();
        return students.get(id);
    }

    @Override
    public Student removeStudent(String id) throws ClassRosterDaoException {
        loadRoster();
        Student student = students.remove(id);
        writeRoster();
        return student;
    }   
    
    private Student unmarshallStudent(String studentAsText) {
        String[] studentTokens = studentAsText.split(DELIMITER);
        String id = studentTokens[0];
        Student studentFromFile = new Student(id);
        studentFromFile.setFirstName(studentTokens[1]);
        studentFromFile.setLastName(studentTokens[2]);
        studentFromFile.setCohort(studentTokens[3]);
        return studentFromFile;
    }
    
    private void loadRoster() throws ClassRosterDaoException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch (FileNotFoundException e) {
            throw new ClassRosterDaoException("-_- Could not load roster data into memory.", e);
        }
        
        String currentLine;
        Student currentStudent;
        
        while (scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentStudent = unmarshallStudent(currentLine);
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        scanner.close();
    }
    
    private String marshallStudent(Student student) {
        String studentAsText = student.getStudentId() + DELIMITER 
                + student.getFirstName() + DELIMITER 
                + student.getLastName() + DELIMITER 
                + student.getCohort();
        return studentAsText;    
    }
    
    private void writeRoster() throws ClassRosterDaoException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterDaoException("Could not save student data.", e);
        }
        
        String studentAsText;
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            studentAsText = marshallStudent(currentStudent);
            out.println(studentAsText);
            // force PrintWriter to write line to file.
            out.flush();
        }
        out.close();
    }
}
