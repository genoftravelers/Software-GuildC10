/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.service;

import fm.dao.FmPersistenceException;
import fm.dao.FmTaxDao;
import fm.dto.FmTax;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmTaxDaoImplStub implements FmTaxDao {

    public FmTax onlyTax;

    public FmTaxDaoImplStub() {
        onlyTax = new FmTax();
        onlyTax.setStateAbbreviation("TX");
        onlyTax.setStateName("Texas");
        onlyTax.setTaxRate(new BigDecimal("4.45"));
    }

    public FmTaxDaoImplStub(FmTax onlyTax) {
        this.onlyTax = onlyTax;

    }

    @Override
    public FmTax addTax(String taxName, FmTax newTax) throws FmPersistenceException {
        if (onlyTax.getStateAbbreviation().equals(newTax.getStateAbbreviation())) {
            return onlyTax;
        } else {
            return null;
        }
    }

    @Override
    public FmTax editTax(String taxName, FmTax newTax) throws FmPersistenceException {
        if (onlyTax.getStateAbbreviation().equals(newTax.getStateAbbreviation())) {
            return onlyTax;
        } else {
            return null;
        }
    }

    @Override
    public FmTax removeTax(String taxName) throws FmPersistenceException {
        if (onlyTax.getStateAbbreviation().equals(taxName)) {
            return onlyTax;
        } else {
            return null;
        }
    }

    @Override
    public FmTax getTax(String taxName) throws FmPersistenceException {
        if (onlyTax.getStateAbbreviation().equals(taxName)) {
            return onlyTax;
        } else {
            return null;
        }
    }

    @Override
    public List<FmTax> getAllTaxs() throws FmPersistenceException {
        List<FmTax> taxList = new ArrayList<>();
        taxList.add(onlyTax);
        return taxList;
    }

}
