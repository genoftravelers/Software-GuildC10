/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.controller;

import fm.dao.FmInvalidOrderDateException;
import fm.dao.FmInvalidOrderNumException;
import fm.dao.FmInvalidProductException;
import fm.dao.FmInvalidTaxException;
import fm.dao.FmPersistenceException;
import fm.dto.FmOrder;
import fm.dto.FmProduct;
import fm.dto.FmTax;
import fm.service.FmService;
import fm.service.OrderDataInvalidException;
import fm.ui.FmView;
import fm.ui.UserIO;
import fm.ui.UserIOConsoleImpl;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmController {

    private UserIO io = new UserIOConsoleImpl();

    public FmService service;
    public FmView view;

    public FmController(FmService service, FmView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        while (keepGoing) {
            try {

                int menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        displayOrders();
                        break;

                    case 2:
                        addAnOrder();
                        break;

                    case 3:
                        editAnOrder();
                        break;

                    case 4:
                        removeAnOrder();
                        break;

                    case 5:
                        exportData();
                        break;

                    case 6:
                        keepGoing = false;
                        break;

                    default:
                        unknownCommand();
                        break;

                }
            } catch (FmPersistenceException
                    | OrderDataInvalidException
                    | FmInvalidTaxException
                    | FmInvalidProductException
                    | FmInvalidOrderDateException
                    | FmInvalidOrderNumException e) {
                view.displayErrorMessage(e.getMessage());

            }
        }
        exitMessage();

    }

    private int getMenuSelection() {
        return view.printMenuAndSelection();
    }

    private void displayOrders() throws FmPersistenceException {
        view.displayDisplayFmBanner();
        LocalDate orderDate = view.getOrderDate();
        
        List<FmOrder> FmList = service.getOrdersByDate(orderDate);
        view.displayFmList(FmList);
        view.displayOrderSuccessfulBanner();
    }

    private void addAnOrder() throws FmPersistenceException, OrderDataInvalidException, FmInvalidTaxException, FmInvalidProductException, FmInvalidOrderDateException, FmInvalidOrderNumException {
        view.displayAddAnOrderBanner();
        List<FmProduct> listOfProduct = service.getAllProducts();
        List<FmTax> listOfState = service.getAllTaxes();
        //partial order obj
        FmOrder newOrder = view.getNewOrderInfo(listOfProduct, listOfState);

        FmOrder fullOrder = service.validateOrder(newOrder);

        if (view.confirmNewOrder(fullOrder)) {
            service.addAnOrder(fullOrder);
            view.displayOrderSuccessfulBanner();
        } else {
            view.displayOrderUnSuccessfulBanner();
        }

    }

    private void editAnOrder() throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException, OrderDataInvalidException, FmInvalidTaxException, FmInvalidProductException {
        view.displayEditAnOrderBanner();

        LocalDate date = view.getOrderDate();
        int orderNum = view.getOrderNumber();
        FmOrder orderToEdit = service.getOrder(date, orderNum);
         orderToEdit= view.getEditedOrderInfo(orderToEdit);
        //get order from services
        FmOrder fullOrder = service.validateOrder(orderToEdit);

        //pass order to view to edit . Pass order Tax, and product
        //   List<FmProduct> listOfProduct = service.getAllProducts();
        // pass it back to service
        if (view.confirmNewOrder(fullOrder)) {
            service.editAnOrder(fullOrder);
            view.displayEditSuccessfulBanner();
        } else {
            view.displayEditUnSuccessfulBanner();
        }
    }

    private void removeAnOrder() throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException {
        view.displayRemoveAnOrderBanner();
        LocalDate date = view.getOrderDate();
        int orderNum = view.getOrderNumber();
        FmOrder orderToRemove = service.getOrder(date, orderNum);
        if (orderToRemove == null) {
            view.displayOrderNotFound();
        } else {
//        service.removeAnOrder(orderToRemove.getOrderDate(), orderToRemove.getOrderNumber());

            if (view.confirmNewOrder(orderToRemove)) {
                service.removeAnOrder(date, orderNum);
                view.displayRemoveSuccessfulBanner();
            } else {
                view.displayRemoveUnSuccessfulBanner();
            }
        }
//.getOrderDate(), orderToRemove.getOrderNumber()
    }

    private void exportData() throws FmPersistenceException {
        view.displayExportDataBanner();

        try {
            service.exportAllData();
            view.displayExportDataSuccessful();
        } catch (FmPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
            view.displayExportDataUnSuccessful();
        }

    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
