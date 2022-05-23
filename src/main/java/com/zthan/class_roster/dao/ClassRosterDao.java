/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zthan.class_roster.dao;

import com.zthan.class_roster.dto.Student;
import java.util.List;

/**
 *
 * @author Zaw L Than
 */
public interface ClassRosterDao {
    Student addStudent(String id, Student student);
    List<Student> getAllStudents();
    Student getStudent(String id);
    Student removeStudent(String id);
}
