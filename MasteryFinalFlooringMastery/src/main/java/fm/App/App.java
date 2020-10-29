/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.App;

import fm.controller.FmController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        FmController controller
                = ctx.getBean("controller", FmController.class);

        controller.run();
    }
}
