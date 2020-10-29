/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dao;

import fm.dto.FmTax;
import fm.dto.FmTax;
import fm.dto.FmTax;
import fm.dto.FmTax;
import fm.dto.FmTax;
import fm.dto.FmTax;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmTaxDaoImpl implements FmTaxDao {

    private Map<String, FmTax> FmTaxes = new HashMap<>();
    private String TAXES_FILE;
    private String DELIMITER = ",";

    public FmTaxDaoImpl() {
        TAXES_FILE = "Datafolder/Data/Taxes.txt";
    }

    public FmTaxDaoImpl(String FmTaxsTextFile) {//testing constructor
        TAXES_FILE = FmTaxsTextFile;
    }

    private FmTax unmarshallFmTax(String FmTaxAsText) {
        String[] FmTaxTokens = FmTaxAsText.split(DELIMITER);

        String stateAbbreviation = FmTaxTokens[0];
        String stateName = FmTaxTokens[1];
        BigDecimal taxRate = new BigDecimal(FmTaxTokens[2]);

        FmTax FmTaxsTextFromFile = new FmTax(stateAbbreviation, stateName, taxRate);

        return FmTaxsTextFromFile;

    }

    private void loadFmTaxes() throws FmPersistenceException {
        Scanner sc;

        try {
            sc = new Scanner(
                    new BufferedReader(
                            new FileReader(TAXES_FILE)));
        } catch (FileNotFoundException e) {
            throw new FmPersistenceException(
                    "-_- could not load product data in memory/CANNOT LOAD TAX DATA", e);
        }
        String currentLine;
        sc.nextLine();
        FmTax currentFmTax;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentFmTax = unmarshallFmTax(currentLine);

            FmTaxes.put(currentFmTax.getStateAbbreviation(), currentFmTax);
        }
        sc.close();
    }

    private String marshallFmTax(FmTax aTax) {
        String FmTaxAsText = aTax.getStateAbbreviation() + DELIMITER;
        FmTaxAsText += aTax.getStateName() + DELIMITER;
        FmTaxAsText += aTax.getTaxRate();

        return FmTaxAsText;
    }

    private void writeTaxInventory() throws FmPersistenceException {
        PrintWriter out;
     //   String itemAsText;
        List<FmTax> taxList = new ArrayList(FmTaxes.values());
        try {
            out = new PrintWriter(new FileWriter(TAXES_FILE));
            out.println("State,StateName,TaxRate");
            
            taxList.stream()
                    .forEach((aTax) -> {
                        String FmTaxAsText = marshallFmTax(aTax);
                        out.println(FmTaxAsText);
                        out.flush();
                    });

            out.close(); //clean up

        } catch (IOException e) {
            throw new FmPersistenceException("COULD NOT SAVE TAX/STATE DATA", e);
        }
    }

    @Override
    public FmTax addTax(String taxName, FmTax newTax) throws FmPersistenceException {
        loadFmTaxes();
        FmTax newFmTaxes = FmTaxes.put(taxName, newTax);
        writeTaxInventory();
        return newFmTaxes;

    }

    @Override
    public FmTax editTax(String taxName, FmTax newTax) throws FmPersistenceException {
        loadFmTaxes();
        FmTax editedTax = FmTaxes.replace(taxName, newTax);
        return editedTax;
    }

    @Override
    public FmTax removeTax(String taxName) throws FmPersistenceException {
        loadFmTaxes();
        FmTax removedProduct = FmTaxes.remove(taxName);
        writeTaxInventory();
        return removedProduct;
    }

    @Override
    public FmTax getTax(String taxName) throws FmPersistenceException {
        loadFmTaxes();
        return FmTaxes.get(taxName);
    }

    @Override
    public List<FmTax> getAllTaxs() throws FmPersistenceException {
        loadFmTaxes();
        return new ArrayList(FmTaxes.values());
    }

}
