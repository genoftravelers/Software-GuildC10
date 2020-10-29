/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dao;

import fm.dto.FmProduct;
import fm.dto.FmProduct;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface FmProductDao {

    FmProduct addProduct(String productName, FmProduct newProduct)throws FmPersistenceException ;

    FmProduct editProduct(String productName, FmProduct newProduct)throws FmPersistenceException ;

    FmProduct removeProduct(String productName)throws FmPersistenceException ;

    FmProduct getProduct(String productName)throws FmPersistenceException ;

    List<FmProduct> getAllProduct()throws FmPersistenceException ;

}
