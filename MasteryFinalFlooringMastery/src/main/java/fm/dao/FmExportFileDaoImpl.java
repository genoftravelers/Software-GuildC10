/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dao;

import fm.dto.FmOrder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmExportFileDaoImpl implements FmExportFileDao {

    public String BACKUP_FILE;
    public String DELIMITER = ",";

    public FmExportFileDaoImpl() {
        BACKUP_FILE = "Datafolder/Fmbackup/DataExport.txt";
    }

    public FmExportFileDaoImpl(String dataExportTextFile) {
        BACKUP_FILE = dataExportTextFile;
    }

    @Override
    public void exportOrders(List<FmOrder> activeOrders) throws FmPersistenceException {
        PrintWriter out;
     //   String orderDataExportAsText;
        try {
            out = new PrintWriter(new FileWriter(new File(BACKUP_FILE)));

            
            out.println("OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total,OrderDate");

            
            activeOrders.stream()
                    .forEach((order) -> {
                        String orderAsExportText = marshallOrder(order);
                        out.println(orderAsExportText);
                        out.flush();
                    });

            out.close();
        } catch (IOException e) {
            throw new FmPersistenceException("Could not export to backup directory");
        }

    }

    public String marshallOrder(FmOrder order) {
        String orderDataExportText = order.getOrderNumber() + DELIMITER;
        orderDataExportText += order.getCustomerName() + DELIMITER;
        orderDataExportText += order.getOrderStateName().getStateAbbreviation() + DELIMITER;
        orderDataExportText += order.getOrderStateName().getTaxRate() + DELIMITER;
        orderDataExportText += order.getOrderProduct().getProductType() + DELIMITER;
        orderDataExportText += order.getOrderArea() + DELIMITER;
        orderDataExportText += order.getOrderProduct().getCostPerSquareFt() + DELIMITER;
        orderDataExportText += order.getOrderProduct().getlaborCostPerSquareFt() + DELIMITER;
        orderDataExportText += order.getOrderMaterialCost() + DELIMITER;
        orderDataExportText += order.getLaborCost() + DELIMITER;
        orderDataExportText += order.getTotalTax() + DELIMITER;
        orderDataExportText += order.getOrderTotal() + DELIMITER;
        orderDataExportText += order.getOrderDate().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        return orderDataExportText;
    }

}
