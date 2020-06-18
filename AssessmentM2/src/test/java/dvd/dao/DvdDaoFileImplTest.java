/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvd.dao;

import dvd.controller.DvdController;
import dvd.dto.Dvd;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class DvdDaoFileImplTest {

    DvdDao testDao;

    public DvdDaoFileImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testcollection.txt";
        new FileWriter(testFile);//blanks the file
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        testDao
                = ctx.getBean("DvdDao", DvdDao.class);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetDvd() throws Exception {
        //Create our method test inputs
        String title = "Gita";
        Dvd dvd = new Dvd(title);
        LocalDate releaseDate = LocalDate.parse("12-12-2010", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        dvd.setReleaseDate("1993");
        dvd.setMpaaRating("PG13");
        dvd.setDirectorName("Phabhupada");
        dvd.setStudio("India");
        dvd.setUserRatingOrNote("Great");

        //Add the dvd to the DAO
        testDao.addDvd(title, dvd);
        //get the student from the DAO
        Dvd retrievedDvd = testDao.getDvd(title);

        //Check the data is equal
        assertEquals(dvd.getTitle(),
                retrievedDvd.getTitle(),
                "Checking dvd title");

        assertEquals(dvd.getReleaseDate(),
                retrievedDvd.getReleaseDate(),
                "Checking dvd Release Date");

        assertEquals(dvd.getMpaaRating(),
                retrievedDvd.getMpaaRating(),
                "Checking MpaaRating");
        assertEquals(dvd.getDirectorName(),
                retrievedDvd.getDirectorName(),
                "Checking Director's name");
//        assertEquals(dvd.getReleaseDate(),
//                retrievedDvd.getReleaseDate(),
//                "Checking Release date");
        assertEquals(dvd.getStudio(),
                retrievedDvd.getStudio(),
                "checking Studio");
        assertEquals(dvd.getUserRatingOrNote(),
                retrievedDvd.getUserRatingOrNote(),
                "Checking Dvd Rating");
    }

    @Test
    public void testAddGetAllDvds() throws Exception {
        //Create our first dvd
        Dvd firstDvd = new Dvd("Gita");
        LocalDate releaseDate = LocalDate.parse("12-12-2010", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        firstDvd.setReleaseDate("1993");
        firstDvd.setMpaaRating("PG13");
        firstDvd.setDirectorName("Universe");
        firstDvd.setStudio("New Jersey");
        firstDvd.setUserRatingOrNote("Great");

        //Create out second dvd
        Dvd secondDvd = new Dvd("Kozmo");
        LocalDate releaseDate2 = LocalDate.parse("12-13-2010", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        secondDvd.setReleaseDate("1994");
        secondDvd.setMpaaRating("PG13");
        secondDvd.setDirectorName("Universe");
        secondDvd.setStudio("Nepal");
        secondDvd.setUserRatingOrNote("Great");

        //Create out third dvd
        Dvd thirdDvd = new Dvd("Karma");
        LocalDate releaseDate3 = LocalDate.parse("12-14-2010", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        thirdDvd.setReleaseDate("1998");
        thirdDvd.setMpaaRating("PG13");
        thirdDvd.setDirectorName("Universe");
        thirdDvd.setStudio("Nepal");
        thirdDvd.setUserRatingOrNote("Great");

        testDao.addDvd(firstDvd.getTitle(), firstDvd);
        testDao.addDvd(secondDvd.getTitle(), secondDvd);
        testDao.addDvd(thirdDvd.getTitle(), thirdDvd);

        //Retrieve the list of all students within the DAO
        List<Dvd> allDvds = testDao.getAllDvds();

        //First check the general contents of the list
        assertNotNull(allDvds, "The list of dvds must not null");
        assertEquals(3, allDvds.size(), "List of students should have 3 students");

        //Then the specifics
        assertTrue(testDao.getAllDvds().contains(firstDvd),
                "The list of dvds should include Gita");
        assertTrue(testDao.getAllDvds().contains(secondDvd),
                "The list of dvds should include Kozmo");
        assertTrue(testDao.getAllDvds().contains(thirdDvd),
                "The list of dvds should include karma");

    }

    @Test
    public void testRemoveDvd() throws Exception {
        //Create third new dvds
        Dvd firstDvd = new Dvd("Gita");
        LocalDate releaseDate = LocalDate.parse("12-12-2010", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        firstDvd.setReleaseDate("1993");
        firstDvd.setMpaaRating("PG13");
        firstDvd.setDirectorName("Universe");
        firstDvd.setStudio("New Jersey");
        //firstDvd.setReleaseDate(releaseDate);
        firstDvd.setUserRatingOrNote("Great");

        //Create out second dvd
        Dvd secondDvd = new Dvd("Kozmo");
        LocalDate releaseDate2 = LocalDate.parse("12-13-2010", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        secondDvd.setReleaseDate("1994");
        secondDvd.setMpaaRating("PG13");
        secondDvd.setDirectorName("Universe");
        secondDvd.setStudio("Nepal");
        //secondDvd.setReleaseDate(releaseDate2);
        secondDvd.setUserRatingOrNote("Great");

        //Create out third dvd
        Dvd thirdDvd = new Dvd("Karma");
        LocalDate releaseDate3 = LocalDate.parse("12-14-2010", DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        thirdDvd.setReleaseDate("1998");
        thirdDvd.setMpaaRating("PG13");
        thirdDvd.setDirectorName("Universe");
        thirdDvd.setStudio("Nepal");
        //thirdDvd.setReleaseDate(releaseDate3);
        thirdDvd.setUserRatingOrNote("Great");

        //Add three of  the Dao
        testDao.addDvd(firstDvd.getTitle(), firstDvd);
        testDao.addDvd(secondDvd.getTitle(), secondDvd);
        testDao.addDvd(thirdDvd.getTitle(), thirdDvd);

        //remove the first dvd = Gita
        Dvd removedDvd = testDao.removeDvd(firstDvd.getTitle());

        //Check that the correct object was removed.
        assertEquals(removedDvd, firstDvd, "The removed Dvd should be Gita.");

        //Get all the dvds
        List<Dvd> allDvds = testDao.getAllDvds();

        //First Check the general contents of the list.
        assertNotNull(allDvds, "All dvds list should not be null.");
        assertEquals(2, allDvds.size(), "All dvds should only have 2 dvds.");

        //Then the specifics
        assertFalse(allDvds.contains(firstDvd), "All dvds should not inlcude Gita.");
        assertTrue(allDvds.contains(secondDvd), "All dvds should  include Kozmo.");
        assertTrue(allDvds.contains(thirdDvd), "All dvds should  include Karma.");

        //Remove the second second dvd = Kozmo
        removedDvd = testDao.removeDvd(secondDvd.getTitle());
        //Check that the correct object was removed.
        assertEquals(removedDvd, secondDvd, "The removed Dvd should be Kozmo");

        //retrive all of the students again, and check the list.
        allDvds = testDao.getAllDvds();

        //Check the contents of the list - it sould be one.
        assertNotNull(allDvds, "All dvds lost should not be null.");
        assertEquals(1, allDvds.size(), "All dvds should only have 1 dvd.");

        //Then the specifics
        assertFalse(allDvds.contains(firstDvd), "All dvds should not inlcude Gita.");
        assertFalse(allDvds.contains(secondDvd), "All dvds should not include Kozmo.");
        assertTrue(allDvds.contains(thirdDvd), "All dvds should not include Karma.");

        //Remove the third dvd
        removedDvd = testDao.removeDvd(thirdDvd.getTitle());
        //Check that the correct object was removed.
        assertEquals(removedDvd, thirdDvd, "The removed Dvd should be Karma");

        //retrieve all of the dvd again, and check the list.
        allDvds = testDao.getAllDvds();

        //check the contents of the list = should be empty
        assertTrue(allDvds.isEmpty(), "The retrieved of dvds should be empty.");

        //Try to "get" all students by their title = they should be null.
        Dvd retrievedDvd = testDao.getDvd(firstDvd.getTitle());
        assertNull(retrievedDvd, "Gita was removed, should be null");
        retrievedDvd = testDao.getDvd(secondDvd.getTitle());
        assertNull(retrievedDvd, "Kozmo was removed, should be null.");
        retrievedDvd = testDao.getDvd(thirdDvd.getTitle());
        assertNull(retrievedDvd, "Karma was removed, should be null");
    }
}
