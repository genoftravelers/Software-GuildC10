/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dao;

import fm.dto.FmTax;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface FmTaxDao {

    FmTax addTax(String taxName, FmTax newTax) throws FmPersistenceException;

    FmTax editTax(String taxName, FmTax newTax) throws FmPersistenceException;

    FmTax removeTax(String taxName) throws FmPersistenceException;

    FmTax getTax(String taxName) throws FmPersistenceException;

    List<FmTax> getAllTaxs() throws FmPersistenceException;
}
