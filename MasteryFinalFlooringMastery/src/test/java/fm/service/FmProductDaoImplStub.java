/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.service;

import fm.dao.FmPersistenceException;
import fm.dao.FmProductDao;
import fm.dto.FmProduct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmProductDaoImplStub implements FmProductDao{
    
    public FmProduct onlyProduct;
    public FmProductDaoImplStub(FmProduct onlyProduct) {
        this.onlyProduct = onlyProduct;
    }
    public FmProductDaoImplStub(){
        onlyProduct = new FmProduct();
        onlyProduct.setCostPerSquareFt(new BigDecimal("3.50"));
        onlyProduct.setLaborCostPerSquareFt(new BigDecimal ("4.15"));
        onlyProduct.setProductType("Tile");
        
    }

    @Override
    public FmProduct addProduct(String productName, FmProduct newProduct) throws FmPersistenceException {
            if(onlyProduct.getProductType().equals(newProduct.getProductType())){
                return onlyProduct;
            }else{
                return null;
            }
    }

    @Override
    public FmProduct editProduct(String productName, FmProduct newProduct) throws FmPersistenceException {
           if(onlyProduct.getProductType().equals(newProduct.getProductType())) {
               return onlyProduct;
           }else{
               return null;
           }
    }

    @Override
    public FmProduct removeProduct(String productName) throws FmPersistenceException {
        if(onlyProduct.getProductType().equals(productName)){
            return onlyProduct;
        }else{
            return null;
        }
    }

    @Override
    public FmProduct getProduct(String productName) throws FmPersistenceException {
        if(onlyProduct.getProductType().equals(productName)) {
            return onlyProduct;
        } else{
            return null;
        }
    }

    @Override
    public List<FmProduct> getAllProduct() throws FmPersistenceException {
       List<FmProduct> productList = new ArrayList<>();
        productList.add(onlyProduct);
        return productList;
    }
    
}
