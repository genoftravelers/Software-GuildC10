/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classroster.service;

import classroster.dao.ClassRosterAuditDao;
import classroster.dao.ClassRosterDao;
import classroster.dao.ClassRosterPersistenceException;
import classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

    private ClassRosterAuditDao auditDao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    ClassRosterDao dao;

    public ClassRosterServiceLayerImpl(ClassRosterDao dao) {
        this.dao = dao;
    }

    @Override
    public void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException {
        /* First check to see if there is already a student associated with
        the given student's id, 
        if so, we are all done here - throw a ClassRosterDuplicateIdException*/
        if (dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException(
                    "ERROR: Could not create student.  Student Id "
                    + student.getStudentId()
                    + " already exists");
        }
        // Now validate all teh fields on the given Student object.
        //This method will throw an exception if any of the validation rules
        //are violated.
        validateStudentData(student);

        //We passed all our business rules checks so go ahead
        // and perssist the Student object
        dao.addStudent(student.getStudentId(), student);

        //The student was successfully created, now write to the audit log
        auditDao.writeAuditEntry("Student " + student.getStudentId() + " CREATED,");
    }

    @Override
    public List<Student> getAllStudents() throws
            ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws
            ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId)
            throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        //Write to audit log
        auditDao.writeAuditEntry("student " + studentId + " REMOVED.");
        return removedStudent;
        //return dao.removeStudent(studentId);
    }

    private void validateStudentData(Student student) throws
            ClassRosterDataValidationException {
        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {
            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }
}
