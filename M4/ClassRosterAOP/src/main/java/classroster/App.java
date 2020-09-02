/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster;

import classroster.controller.ClassRosterController;
import classroster.dao.ClassRosterAuditDao;
import classroster.dao.ClassRosterAuditDaoFileImpl;
import classroster.dao.ClassRosterDao;
import classroster.dao.ClassRosterDaoFileImpl;
import classroster.service.ClassRosterServiceLayer;
import classroster.service.ClassRosterServiceLayerImpl;
import classroster.ui.ClassRosterView;
import classroster.ui.UserIO;
import classroster.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class App {

    public static void main(String[] args) {
        // UserIO myIo = new UserIOConsoleImpl();
        // ClassRosterView myView = new ClassRosterView(myIo);
        // ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        // ClassRosterAuditDao myAuditDao = 
        //       new ClassRosterAuditDaoFileImpl();
        // ClassRosterServiceLayer myService = 
        //       new ClassRosterServiceLayerImpl(myDao, myAuditDao);
        // ClassRosterController controller = 
        //       new ClassRosterController(myService, myView);
        // controller.run();
 
        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassRosterController controller = 
           ctx.getBean("controller", ClassRosterController.class);
        controller.run();
        
        
                // Instantiate the UserIO implementation
//        UserIO myIo = new UserIOConsoleImpl();
//        // Instantiate the View and wire the UserIO implementation into it
//        ClassRosterView myView = new ClassRosterView(myIo);
//        // Instantiate the DAO
//        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
//        // Instantiate the Audit DAO
//        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoFileImpl();
//        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
//        ClassRosterServiceLayer myService = new ClassRosterServiceLayerImpl(myDao, myAuditDao);
//        // Instantiate the Controller and wire the Service Layer into it
//        ClassRosterController controller = new ClassRosterController(myService, myView);
//        // Kick off the Controller
    }
}
