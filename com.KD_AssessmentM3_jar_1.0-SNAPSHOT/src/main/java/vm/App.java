/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vm.controller.VmController;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class App {

    public static void main(String[] args) {
//        UserIO myIo = new UserIOConsoleImpl();
//        VmView myView = new VmView(myIo);
//        VmDao myDao = new VmDaoFileImpl();
//        VmAuditDao myAuditDao = new VmAuditDaoImpl();
//        VmService myService = new VmServiceImpl(myDao, myAuditDao);
//        VmController controller = new VmController(myService, myView);

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        VmController controller
                = ctx.getBean("controller", VmController.class);

        controller.run();

    }
}
