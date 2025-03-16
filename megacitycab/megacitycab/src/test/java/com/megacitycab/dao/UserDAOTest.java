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
 * @author NEW
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
    @Test
    public void testGetAllUsernames() throws Exception {
        System.out.println("getAllUsernames");
        UserDAO instance = new UserDAO();
        List<String> result = instance.getAllUsernames();
        
        assertNotNull(result, "User list should not be null");
        assertTrue(result. size() >=0,"User list should have at least zero users");
        System.out.println("Database Users: " + result);
        
    }

    /**
     * Test of createUser method, of class UserDAO.
     */
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("CreateUser");
        String us_loginusername = "";
        String us_Password = "";
        String us_Email = "";
        String us_fullname = "";
        String us_Contact_No = "";
        String us_NIC = "";
        String us_Address = "";
        UserDAO instance = new UserDAO();
        boolean expResult = true;
        boolean result = instance.createUser(us_loginusername, us_Password, us_Email, us_fullname, us_Contact_No, us_NIC, us_Address);
        assertEquals(expResult, result, "User creation failed!");
        System.out.println("Database Users: " + result);
        
    }

    /**
     * Test of updateUser method, of class UserDAO.
     */
    /*@Test
    public void testUpdateUser() throws Exception {
        System.out.println("updateUser");
        String username = "";
        String newPassword = "";
        String newEmail = "";
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.updateUser(username, newPassword, newEmail);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUser method, of class UserDAO.
     */
    /*@Test
    public void testDeleteUser() throws Exception {
        System.out.println("deleteUser");
        String username = "";
        UserDAO instance = new UserDAO();
        boolean expResult = false;
        boolean result = instance.deleteUser(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of authenticateUser method, of class UserDAO.
     */
    /*@Test
    public void testAuthenticateUser() throws Exception {
        System.out.println("authenticateUser");
        String username = "";
        String password = "";
        UserDAO instance = new UserDAO();
        Map<String, String> expResult = null;
        Map<String, String> result = instance.authenticateUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
