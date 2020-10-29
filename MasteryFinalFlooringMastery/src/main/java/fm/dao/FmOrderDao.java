/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dao;

import fm.dto.FmOrder;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface FmOrderDao {

    FmOrder addOrder(FmOrder newOrder) throws FmPersistenceException;

    FmOrder editOrder(FmOrder order) throws FmPersistenceException;

    FmOrder removeOrder(LocalDate date, int orderNum) throws FmPersistenceException, FmInvalidOrderDateException, FmInvalidOrderNumException;

    FmOrder getOrderByDateandId(LocalDate orderDate, int orderNumber) throws FmPersistenceException;

    List<FmOrder> getAllOrdersForDate(LocalDate orderDate) throws FmPersistenceException;

    int getOrderNumber() throws FmPersistenceException;

    List<LocalDate> orderDate() throws FmPersistenceException;

    List<FmOrder> getAllOrders() throws FmPersistenceException;

    Map<LocalDate, Map<Integer, FmOrder>> exportAllData() throws FmPersistenceException;

}
