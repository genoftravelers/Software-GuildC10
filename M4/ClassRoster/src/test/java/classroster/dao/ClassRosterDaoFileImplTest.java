/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.dao;

import classroster.dto.Student;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class ClassRosterDaoFileImplTest {

    ClassRosterDao testDao;

    public ClassRosterDaoFileImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testroster.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new ClassRosterDaoFileImpl(testFile);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetStudent() throws Exception {
        // Create our method test inputs
        String studentId = "0001";
        Student student = new Student(studentId);
        student.setFirstName("Ada");
        student.setLastName("Lovelace");
        student.setCohort("Java-May-1845");

        //  Add the student to the DAO
        testDao.addStudent(studentId, student);
        // Get the student from the DAO
        Student retrievedStudent = testDao.getStudent(studentId);

        // Check the data is equal
        assertEquals(student.getStudentId(),
                retrievedStudent.getStudentId(),
                "Checking student id.");
        assertEquals(student.getFirstName(),
                retrievedStudent.getFirstName(),
                "Checking student first name.");
        assertEquals(student.getLastName(),
                retrievedStudent.getLastName(),
                "Checking student last name.");
        assertEquals(student.getCohort(),
                retrievedStudent.getCohort(),
                "Checking student cohort.");
    }

}
