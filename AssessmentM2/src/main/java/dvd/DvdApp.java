/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvd;

import dvd.controller.DvdController;
import dvd.dao.DvdDao;
import dvd.dao.DvdDaoFileImpl;
import dvd.ui.DvdView;
import dvd.ui.UserIO;
import dvd.ui.UserIOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
// The main is modified so that the dependency injection is implied instead of
//the controller.
// The app class will configure, instantiate and assemble the classes in our app.
public class DvdApp {

    public static void main(String[] args) {

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        DvdController controller
                = ctx.getBean("controller", DvdController.class);
        controller.run();
//        //Declare UserIO variable and initialize it with a userIOImpl reference.
//        UserIO myIo = new UserIOImpl();
//        //Declare and instantiate a DvdView object, passing the UserIO created in 
//        //the previous step into the constructor.
//        DvdView myView = new DvdView(myIo);
//        //Declare a DvdDao variable and initialize it with a DvdFileImpl 
//        //reference
//        DvdDao myDao = new DvdDaoFileImpl();
//        //Instantiate a DvdController, passing the DvdDao and DvdView object
//        //into the constructor.
//        DvdController controller = new DvdController(myDao, myView);
//        //Call the run method on the controller to kick things off.
//        controller.run();

    }
}
