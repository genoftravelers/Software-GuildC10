/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.service;

import classroster.dao.ClassRosterAuditDao;
import classroster.dao.ClassRosterPersistenceException;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class ClassRosterAuditDaoStubImpl implements ClassRosterAuditDao {

    @Override
    public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
        //do nothing . . .
    }
    
    
}
