/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.megacitycab.dao;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Poorna Sajiwani
 */
public class UserDAOTest {
    
    public UserDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAllUsernames method, of class UserDAO.
     */
//    @Test
//    public void testGetAllUsernames() throws Exception {
//        System.out.println("getAllUsernames");
//        UserDAO instance = new UserDAO();
//        List<String> expResult = null;
//        List<String> result = instance.getAllUsernames();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of createUser method, of class UserDAO.
     */
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("createUser");
        String us_full_name = "";
        String us_login_user_name = "";
        String us_password = "";
        String us_email = "";
        String us_type = "";
        String us_address = "";
        String us_contact_no = "";
        String us_nic = "";
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.createUser(us_full_name, us_login_user_name, us_password, us_email, us_type, us_address, us_contact_no, us_nic);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } 
}

//    /**
//     * Test of updateUser method, of class UserDAO.
//     */
//    @Test
//    public void testUpdateUser() throws Exception {
//        System.out.println("updateUser");
//        String username = "";
//        String newPassword = "";
//        String newEmail = "";
//        UserDAO instance = new UserDAO();
//        boolean expResult = false;
//        boolean result = instance.updateUser(username, newPassword, newEmail);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteUser method, of class UserDAO.
//     */
//    @Test
//    public void testDeleteUser() throws Exception {
//        System.out.println("deleteUser");
//        String username = "";
//        UserDAO instance = new UserDAO();
//        boolean expResult = false;
//        boolean result = instance.deleteUser(username);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of authenticateUser method, of class UserDAO.
//     */
//    @Test
//    public void testAuthenticateUser() throws Exception {
//        System.out.println("authenticateUser");
//        String username = "";
//        String password = "";
//        UserDAO instance = new UserDAO();
//        Map<String, String> expResult = null;
//        Map<String, String> result = instance.authenticateUser(username, password);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
