/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm;

import vm.controller.VmController;
import vm.dao.VmAuditDao;
import vm.dao.VmAuditDaoImpl;
import vm.dao.VmDao;
import vm.dao.VmDaoFileImpl;
import vm.service.VmService;
import vm.service.VmServiceImpl;
import vm.ui.UserIO;
import vm.ui.UserIOConsoleImpl;
import vm.ui.VmView;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        VmView myView = new VmView(myIo);
        VmDao myDao = new VmDaoFileImpl();
        VmAuditDao myAuditDao = new VmAuditDaoImpl();
        VmService myService = new VmServiceImpl(myDao, myAuditDao);
        VmController controller = new VmController(myService, myView);

        controller.run();

    }
}
