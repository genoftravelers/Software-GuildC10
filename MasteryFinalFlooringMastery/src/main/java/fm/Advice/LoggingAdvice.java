/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.Advice;

import fm.dao.FmAuditDao;
import fm.dao.FmPersistenceException;
import org.aspectj.lang.JoinPoint;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class LoggingAdvice {

    FmAuditDao auditDao;

    public LoggingAdvice(FmAuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FmPersistenceException e) {
            System.err.println(
                    "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

    public void createDataValidationExceptionAudit(JoinPoint jp, Exception ex) {
        String auditEntry = "Thrown: " + jp.getSignature().getName() + ":: Message: " + ex.getMessage();

        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FmPersistenceException e) {
            System.err.println(
                    "ERROR: could not write audit entry on exception thrown");
        }
    }
}
