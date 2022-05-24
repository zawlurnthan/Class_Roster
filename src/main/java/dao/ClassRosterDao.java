/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Student;
import java.util.List;

/**
 *
 * @author Zaw L Than
 */
public interface ClassRosterDao {
    Student addStudent(String id, Student student) throws ClassRosterDaoException;
    List<Student> getAllStudents() throws ClassRosterDaoException;
    Student getStudent(String id) throws ClassRosterDaoException;
    Student removeStudent(String id) throws ClassRosterDaoException;
}
