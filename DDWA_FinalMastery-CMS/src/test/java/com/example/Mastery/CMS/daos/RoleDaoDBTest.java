/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.daos;

import com.example.Mastery.CMS.dtos.Role;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDaoDBTest {

    @Autowired
    RoleDao roleDao;

    public RoleDaoDBTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        List<Role> roles = roleDao.getAllRoles();
        for (Role role : roles) {
            roleDao.deleteRole(role.getId());
        }
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getRoleById method, of class RoleDaoDB.
     */
    @Test
    public void testGetRoleById() {

        Role role = new Role();
        role.setRole("Test role");
        role = roleDao.createRole(role);

        Role fromDao = roleDao.getRoleById(role.getId());

        assertEquals(role, fromDao);
    }

    /**
     * Test of getRoleByRole method, of class RoleDaoDB.
     */
    @Test
    public void testGetAddRoleByRole() {
        Role role = new Role();
        role.setRole("testRole");

        role = roleDao.createRole(role);

        Role fromDao = roleDao.getRoleByRole(role.getRole());

        assertEquals(role, fromDao);
    }

    /**
     * Test of getAllRoles method, of class RoleDaoDB.
     */
    @Test
    public void testGetAllRoles() {
        Role role = new Role();
        role.setRole("firstrole");
        role = roleDao.createRole(role);

        Role role2 = new Role();
        role.setRole("secondrole");
        role2 = roleDao.createRole(role);

        List<Role> roles = roleDao.getAllRoles();

        assertEquals(2, roles.size());
        assertTrue(roles.contains(role));
        assertTrue(roles.contains(role2));

    }

    /**
     * Test of deleteRole method, of class RoleDaoDB.
     */
    @Test
    public void testDeleteRole() {
        Role role = new Role();
        role.setRole("testRole");
        role = roleDao.createRole(role);

        Role fromDao = roleDao.getRoleById(role.getId());

        assertEquals(role, fromDao);
        roleDao.deleteRole(role.getId());
        fromDao = roleDao.getRoleById(role.getId());

        assertNull(fromDao);
    }

    /**
     * Test of updateRole method, of class RoleDaoDB.
     */
    @Test
    public void testUpdateRole() {
        Role role = new Role();
        role.setRole("updateRole");
        role = roleDao.createRole(role);

        Role fromDao = roleDao.getRoleById(role.getId());

        assertEquals(role, fromDao);

        role.setRole("updatedRole");
        roleDao.updateRole(role);

        assertNotEquals(role, fromDao);
        fromDao = roleDao.getRoleById(role.getId());

        assertEquals(role, fromDao);

    }

}
