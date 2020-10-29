/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.service;

import fm.dao.*;
import fm.dto.FmOrder;
import java.util.List;
import org.junit.jupiter.api.Order;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmExportDaoImplStub implements FmExportFileDao {

    @Override
    public void exportOrders(List<FmOrder> activeOrders){
        //do nth
    }
}
