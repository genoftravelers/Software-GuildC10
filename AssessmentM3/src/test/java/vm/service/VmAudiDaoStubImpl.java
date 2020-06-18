/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vm.service;

import vm.dao.VmAuditDao;
import vm.dao.VmPersistenceException;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class VmAudiDaoStubImpl implements VmAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws VmPersistenceException {

        //...do nothing
    }
}
