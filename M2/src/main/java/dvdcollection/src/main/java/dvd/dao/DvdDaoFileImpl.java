/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvd.dao;

import dvd.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class DvdDaoFileImpl implements DvdDao {

    private Map<String, Dvd> dvds = new HashMap<>();//Hashmap to hold data.

    //Create two constants in our DAO- one for the name of the file that holds
    //data and one for the DELIMITER.
    public static final String COLLECTION_FILE = "collection.txt";
    public static final String DELIMITER = "::";

    //Use loadRoster and writeRoster methods so they read from and write to the file.
    @Override
    public Dvd addDvd(String title, Dvd Dvd) throws DvdDaoException {
        //This method reads all the dvd object from file and loads them into our map.
        //writes all the Dvd info to the file to make sure the change is persisted.
        loadCollection();
        Dvd newDvd = dvds.put(title, Dvd);
        writeCollection();
        return newDvd;
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdDaoException {
        //This method reads all the Dvd Objects from file, get them out of the map,
        //and then returns an ArrayList of the dvd objects to the caller.
        loadCollection();
        return new ArrayList(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) throws DvdDaoException {
        //This method reads all the dvd objects from the file, gets the
        //requested Student out of the map, and then returns the student object 
        //to the caller.
        loadCollection();
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title) throws DvdDaoException {
        //This method ensures all dvd objects are read in from the file and 
        //loaded into out map. Then the method removes the specified dvd object
        //from our map, writes the updated dvd map to the file and returns
        //the removed student object to the caller.
        loadCollection();
        Dvd removedDvd = dvds.remove(title);
        writeCollection();
        return removedDvd;
    }

    @Override

    public Dvd editDvdInfo(String title, Dvd Dvd) throws DvdDaoException {
        //This method reads all the dvd object from file and loads them into our map.
        //writes all the Dvd info to the file to make sure the change is persisted.
        loadCollection();
        Dvd editedDvd = dvds.put(title, Dvd);//edited dvd takes in title
        writeCollection();//writes the edits.
        return editedDvd;//returns the final edits.

    }

    private Dvd unmarshallDvd(String dvdAsText) {
        //dvdAsText is expecting a line read in from our file.
        //The line uses a format
        //We then split that line on our DELIMITER - which we we are using as ::
        //leaving us with an array of strings stored in dvdTokens
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        //.split - split each line into an array of Strings.
        //dvd Title is [0] in the array.
        String title = dvdTokens[0];
        //which we can use to create a new Dvd object to satisfy the
        //requirement of the Dved constructor.
        Dvd dvdFromFile = new Dvd(title);
        //However, there are 5 remaining tokens that need to be set into the
        //new dvd object. we do this manually using the setters.
        //Index 1 - releaseDate
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        //Index 2 - mpaa Rating
        dvdFromFile.setMpaaRating(dvdTokens[2]);
        //Index 3 - director's name
        dvdFromFile.setDirectorName(dvdTokens[3]);
        //Index 4 - studio
        dvdFromFile.setStudio(dvdTokens[4]);
        //Index 5 - userRating/note
        dvdFromFile.setUserRatingOrNote(dvdTokens[5]);
        //We have created a dvd, now we return it.
        return dvdFromFile;
    }

    //This method reads the collection file into memory.
    private void loadCollection() throws DvdDaoException {
        Scanner sc;

        try {
            //create Scanner for reading the file
            sc = new Scanner(
                    new BufferedReader(
                            new FileReader(COLLECTION_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdDaoException("-___- Could not load collection into memory.", e);
        }//currentLine holds the most recent read from the file
        String currentLine;
        //currentDvd holds the most recent dvd unmarshalled
        Dvd currentDvd;
        //Go through COLLECTION_FILE line by line, decoding each line into a 
        //Dvd object by calling the unmarshallDvd method.
        //Process while we have more lines in the file
        while (sc.hasNextLine()) {
            //get the next line in the file.
            currentLine = sc.nextLine();
            //unmarshall the line into a Dvd
            currentDvd = unmarshallDvd(currentLine);
            //We are going to use the dvd title as the map key for our dvd object.
            //put currentDvd into the map using dvd title as the key
            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        //close scanner
        sc.close();

    }

    private String marshallDvd(Dvd aDvd) {
        //We are turning the dvd object into aline of text for our file.
        //We need to get each property first.
        //then concatenate with our DELIMITER as a kind of spacer.
        //Start with the dvd title, since that's suppose to be first.
        String dvdAsText = aDvd.getTitle() + DELIMITER;
        //Add the rest of the properties in the correct order.
        //release date
        dvdAsText += aDvd.getReleaseDate() + DELIMITER;
        //mpaarating
        dvdAsText += aDvd.getMpaaRating() + DELIMITER;
        //director name
        dvdAsText += aDvd.getDirectorName() + DELIMITER;
        //studio
        dvdAsText += aDvd.getStudio() + DELIMITER;
        //userRating.note
        dvdAsText += aDvd.getUserRatingOrNote();
        // We now have turned a dvd to text! return it!
        return dvdAsText;

    }

    /**
     * Writes all dvds in the collection from memory out to a COLLECTION _FILE.
     * See loadCollection for file format.
     *
     * @throws ClassCollection DaoException if an error occurs writing to the
     * file
     */
    private void writeCollection() throws DvdDaoException {
        // We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(COLLECTION_FILE));
        } catch (IOException e) {
            throw new DvdDaoException("Could not save dvd data.", e);
        }
        // Write out the Dvd objects to the collection  file.
        // NOTE TO THE APPRENTICES: We could just grab the dvd map,
        // get the Collection of Dvds and iterate over them but we've
        // already created a method that gets a List of Dvds so
        // we'll reuse it.
        String dvdAsText;
        List<Dvd> dvdList = new ArrayList(dvds.values());
        for (Dvd currentDvd : dvdList) {
            //turn a dvd into a string
            dvdAsText = marshallDvd(currentDvd);
            //write the dvd object to the file.
            out.println(dvdAsText);
            //force PrintWriter to write line to the file.
            out.flush();
        }
        //clean up
        out.close();

    }

}
