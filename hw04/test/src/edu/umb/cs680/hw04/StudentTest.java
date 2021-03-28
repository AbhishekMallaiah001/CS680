package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void testcreateInStateStudent() {
        StudentStatus expected_status = StudentStatus.INSTATE;
        Student s =  Student.createInStateStudent("Dharmin", "umass");
        assertEquals(expected_status, s.getStatus());

    }
    @Test
    void testcreateOutStateStudent() {
        StudentStatus expected_status = StudentStatus.OUTSTATE;
        Student s =  Student.createOutStateStudent("Dharmin", "umass", 2000);
        assertEquals(expected_status, s.getStatus());
    }

    @Test
    void testcreateIntlStudent() {
        StudentStatus expected_status = StudentStatus.INTL;
        Student s =  Student.createIntlStudent("Dharmin", "umass", 235,"banglore");
        assertEquals(expected_status, s.getStatus());
    }
}