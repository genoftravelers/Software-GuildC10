/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dao;

import fm.dto.FmOrder;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface FmExportFileDao {

    void exportOrders(List<FmOrder> activeOrders) throws FmPersistenceException;
}
