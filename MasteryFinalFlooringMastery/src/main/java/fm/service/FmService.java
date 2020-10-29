/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.service;

import fm.dao.FmInvalidOrderDateException;
import fm.dao.FmInvalidOrderNumException;
import fm.dao.FmInvalidProductException;
import fm.dao.FmInvalidTaxException;
import fm.dao.FmPersistenceException;
import fm.dto.FmOrder;
import fm.dto.FmProduct;
import fm.dto.FmTax;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface FmService {

    //passthrough method to the dao
    FmOrder addAnOrder(FmOrder newOrder) throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException;

    //passthrough method to the dao
    FmOrder editAnOrder(FmOrder editedOrder) throws FmPersistenceException;

    //passthrough method to the dao.
    FmOrder removeAnOrder(LocalDate date, int orderNum) throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException;

    //passthrough method to dao, but it throws exceptions
    FmOrder getOrder(LocalDate orderDate, int orderNumber) throws FmPersistenceException, FmPersistenceException, FmInvalidOrderDateException;

    //passthrough method to dao
    List<FmOrder> getOrdersByDate(LocalDate date) throws FmPersistenceException;

    //passthrough method to dao
    List<FmProduct> getAllProducts() throws FmPersistenceException;

    //passthrough method to dao
    List<FmTax> getAllTaxes() throws FmPersistenceException;

    //
    FmOrder validateOrder(FmOrder order) throws OrderDataInvalidException, FmPersistenceException, FmInvalidTaxException, FmInvalidProductException;

    //called on by validateOrder
    void calculateOrder(FmOrder newOrder);

    //calls on dao, returns +1
    int generateOrderNumber() throws FmPersistenceException;

    //not being used rn
    void validateOrderNumber(LocalDate date, int orderNumber) throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException;

    //calls on daos
    void exportAllData() throws FmPersistenceException;

}
