/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.service;

import fm.dao.FmAuditDao;
import fm.dao.FmPersistenceException;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class FmAuditDaoImplStub implements FmAuditDao{
    @Override
    public void writeAuditEntry(String entry) throws FmPersistenceException {
        //do nth
    }
}
