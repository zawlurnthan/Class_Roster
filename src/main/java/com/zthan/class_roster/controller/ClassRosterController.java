/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zthan.class_roster.controller;

import com.zthan.class_roster.dao.ClassRosterDao;
import com.zthan.class_roster.dao.ClassRosterDaoException;
import com.zthan.class_roster.dto.Student;
import com.zthan.class_roster.ui.ClassRosterView;
import java.util.List;

/**
 *
 * @author Zaw L Than
 */
public class ClassRosterController {
    
    private final ClassRosterView view;
    private final ClassRosterDao dao;
    
    public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
        this.dao = dao;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        try {
                    while (keepGoing) {
            
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    listStudents();
                    break;
                    
                case 2:
                   createStudent();
                   break;
                   
                case 3:
                    viewStudent();
                    break;
                    
                case 4:
                    removeStudent();
                    break;
                    
                case 5:
                    keepGoing = false;
                    break;
                    
                default:
                    unknownCommand();
            }
        }
        exitMessage();
        } catch (ClassRosterDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createStudent() throws ClassRosterDaoException {
        view.displayCreatedStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreatedSuccessBanner();
    }
    
    private void listStudents() throws ClassRosterDaoException {
        view.displayAllStudentsBanner();
        List<Student> studentList = dao.getAllStudents();
        view.displayStudentList(studentList);
    }
    
    private void viewStudent() throws ClassRosterDaoException {
        view.displayStudentBanner();
        String id = view.getStudentIdChoice();
        Student student = dao.getStudent(id);
        view.displayStudent(student);
    }
    
    private void removeStudent() throws ClassRosterDaoException {
        view.displayRemoveStudentBanner();
        String id = view.getStudentIdChoice();
        Student student = dao.removeStudent(id);
        view.displayRemoveResult(student);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
}
