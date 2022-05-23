/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zthan.class_roster;

import com.zthan.class_roster.controller.ClassRosterController;
import com.zthan.class_roster.dao.ClassRosterDao;
import com.zthan.class_roster.dao.ClassRosterDaoFileImpl;
import com.zthan.class_roster.ui.ClassRosterView;
import com.zthan.class_roster.ui.UserIO;
import com.zthan.class_roster.ui.UserIOConsoleImpl;

/**
 *
 * @author Zaw L Than
 */
public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        ClassRosterView view = new ClassRosterView(io);
        ClassRosterDao dao = new ClassRosterDaoFileImpl();
        ClassRosterController controller = new ClassRosterController(dao, view);
        controller.run();
    }
}
