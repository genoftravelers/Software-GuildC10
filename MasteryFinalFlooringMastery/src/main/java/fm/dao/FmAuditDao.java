/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fm.dao;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface FmAuditDao {
    public void writeAuditEntry(String entry) throws FmPersistenceException;
}
