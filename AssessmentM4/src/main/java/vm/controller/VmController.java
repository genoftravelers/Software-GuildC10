/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.controller;

import java.math.BigDecimal;
import java.util.Map;
import vm.dao.VmPersistenceException;
import vm.dto.VmItem;
import vm.service.InsufficientMoneyException;
import vm.service.ItemDoesNotExistException;
import vm.service.ItemValidationException;
import vm.service.VmDuplicateNameException;
import vm.service.VmService;
import vm.ui.VmView;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class VmController {

    private VmService service;
    private VmView view;
    // private VmView view = new VmView();
    //  private UserIO io = new UserIOConsoleImpl();

    public VmController(VmService service, VmView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        try {
            while (keepGoing) {
                int menuSelection = 0;

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        //  io.print("Please enter the amount.");
                        purchase();
                        break;
                    case 2:
                        keepGoing = false;
                        break;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
            view.displayExitMessage();
        } catch (VmPersistenceException 
         | InsufficientMoneyException 
         | ItemDoesNotExistException 
         | ItemValidationException 
         | VmDuplicateNameException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    private int getMenuSelection() throws VmPersistenceException {
        
        return view.printMenuSelection(service.getAllItems());
    }

    private void purchase() throws VmPersistenceException, InsufficientMoneyException, ItemDoesNotExistException, ItemValidationException, VmDuplicateNameException {

        BigDecimal money = view.insertAmount();
        String itemName = view.getItemName();

        VmItem anItem = service.purchaseItem(itemName, money);

        Map returnChange = service.returnChange(anItem.getItemCost(), money);
        view.purchase(itemName, returnChange);

         view.displayPurchaseSuccessful();
    }

}
