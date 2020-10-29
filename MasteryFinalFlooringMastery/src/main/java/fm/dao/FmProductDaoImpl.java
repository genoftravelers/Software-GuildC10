/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dao;

import fm.dto.FmProduct;
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
import org.eclipse.core.internal.runtime.Product;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmProductDaoImpl implements FmProductDao {

    private Map<String, FmProduct> FmProducts = new HashMap<>();
    private String PRODUCTS_FILE;
    private String DELIMITER = ",";

    public FmProductDaoImpl() {
        PRODUCTS_FILE = "Datafolder/Data/Products.txt";
    }

    public FmProductDaoImpl(String FmProductsTextFile) {//testing constructor
        PRODUCTS_FILE = FmProductsTextFile;
    }

    private FmProduct unmarshallFmProduct(String FmProductAsText) {
        String[] FmProductTokens = FmProductAsText.split(DELIMITER);

        String productName = FmProductTokens[0];
        BigDecimal costPerSqFt = new BigDecimal(FmProductTokens[1]);
        BigDecimal laborCostPersqFt = new BigDecimal(FmProductTokens[2]);

        FmProduct FmProductFromFile = new FmProduct(productName, costPerSqFt, laborCostPersqFt);

        return FmProductFromFile;

    }

    private void loadFmProducts() throws FmPersistenceException {
        Scanner sc;

        try {
            sc = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCTS_FILE)));
        } catch (FileNotFoundException e) {
            throw new FmPersistenceException(
                    "-_- could not load product data in memory......", e);
        }
        String currentLine;
        sc.nextLine();
        FmProduct currentFmProduct;

        while (sc.hasNextLine()) {
            currentLine = sc.nextLine();
            currentFmProduct = unmarshallFmProduct(currentLine);

            FmProducts.put(currentFmProduct.getProductType(), currentFmProduct);
        }
        sc.close();
    }

    private String marshallFmProduct(FmProduct aProduct) {
        String FmProductAsText = aProduct.getProductType() + DELIMITER;
        FmProductAsText += aProduct.getCostPerSquareFt() + DELIMITER;
        FmProductAsText += aProduct.getlaborCostPerSquareFt();

        return FmProductAsText;
    }

    private void writeProductInventory() throws FmPersistenceException {
        PrintWriter out;
        //String itemAsText;
        List<FmProduct> productList = new ArrayList(FmProducts.values());

        try {
            out = new PrintWriter(new FileWriter(PRODUCTS_FILE));

            out.println("ProductType,CostPerSquareFoot,LaborCostPerSquareFoot");

            productList.stream()
                    .forEach((aProduct) -> {
                        String FmProductAsText = marshallFmProduct(aProduct);
                        out.println(FmProductAsText);
                        out.flush();
                    });

            out.close(); //clean up

        } catch (IOException e) {
            throw new FmPersistenceException("COULD NOT SAVE PRODUCT DATA", e);
        }
    }

    @Override
    public FmProduct addProduct(String productName, FmProduct newProduct) throws FmPersistenceException {
        loadFmProducts();
        FmProduct newFmProduct = FmProducts.put(productName, newProduct);
        writeProductInventory();
        return newFmProduct;
    }

    @Override
    public FmProduct editProduct(String productName, FmProduct newProduct) throws FmPersistenceException {
        loadFmProducts();
        FmProduct editedProduct = FmProducts.replace(productName, newProduct);
        return editedProduct;
    }

    @Override
    public FmProduct removeProduct(String productName) throws FmPersistenceException {
        loadFmProducts();
        FmProduct removedProduct = FmProducts.remove(productName);
        writeProductInventory();
        return removedProduct;
    }

    @Override
    public FmProduct getProduct(String productName) throws FmPersistenceException {
        loadFmProducts();
        return FmProducts.get(productName);
    }

    @Override
    public List<FmProduct> getAllProduct() throws FmPersistenceException {
        loadFmProducts();
        return new ArrayList(FmProducts.values());
    }

}
