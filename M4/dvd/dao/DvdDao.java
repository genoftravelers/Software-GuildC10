/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvd.dao;

import dvd.dto.Dvd;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
/*
DAO is in charge of storing and accessing the data.
This interface defines the methods that will be implemented and can 
be used in classes.
Controller will only use this Dao interface to reference the Dao, its 
unaware of the implementation details.
 */
public interface DvdDao {

    /**
     * Adds the given Dvds to the collection and associates it with the given
     * Title. If there is already a dvd associated with the given title it will
     * return that student object, otherwise it will return null.
     *
     * @param title with which dvd is to be associated
     * @param dvd dvd to be added to the collection
     * @return the Dvd object previously associated with the given title if it
     * exists, null otherwise
     */
    Dvd addDvd(String title, Dvd Dvd) throws DvdDaoException;

    /**
     * Returns a list of all dvds in the collection.
     *
     * @return List containing all dvds in the collection.
     */
    List<Dvd> getAllDvds() throws DvdDaoException;

    /**
     * Returns the Dvd object associated with the given dvd name. Returns null
     * if no such student exists
     *
     * @param title title of the dvd to retrieve
     * @return the Dvd object associated with the given title, null if no such
     * dvd exists
     */
    Dvd getDvd(String title) throws DvdDaoException;

    /**
     * Removes from the collection the dvd associated with the title. Returns
     * the Dvd object that is being removed or null if there is no dvd
     * associated with the given title
     *
     * @param title title of dvd to be removed.
     * @return Dvd object that was removed or null if no Dvd was associated with
     * the given title.
     */
    Dvd removeDvd(String title) throws DvdDaoException;

    /**
     * * Edits the given Dvd associated with the given Title. If there is
     * already a dvd associated with the given title it will return that student
     * object, otherwise it will return null. edit from the collection with the
     * associated title.
     *
     * * @param title with which dvd is to be associated
     * @param dvd dvd to be edited.
     * @return the Dvd object previously associated with the given title if it
     * exists, null otherwise
     *
     *
     */
    Dvd editDvdInfo(String title, Dvd Dvd) throws DvdDaoException;

}
