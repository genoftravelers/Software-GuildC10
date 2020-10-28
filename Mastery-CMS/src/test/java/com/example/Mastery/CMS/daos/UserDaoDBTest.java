/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.daos;

import com.example.Mastery.CMS.dtos.Blogpost;
import com.example.Mastery.CMS.dtos.Hashtag;
import com.example.Mastery.CMS.dtos.Role;
import com.example.Mastery.CMS.dtos.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
public class UserDaoDBTest {

    @Autowired
    UserDao userDao;

    @Autowired
    BlogpostDao blogpostDao;

    @Autowired
    HashtagDao hashtagDao;

    @Autowired
    RoleDao roleDao;

    public UserDaoDBTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        //remove all blogpost
        List<Blogpost> blogposts = blogpostDao.getAllBlogposts();
        for (Blogpost blogpost : blogposts) {
            blogpostDao.deleteBlogpost(blogpost.getId());
        }

        //remove all User
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            userDao.deleteUser(user.getId());
        }

        //remove all hashtags
        List<Hashtag> hashtags = hashtagDao.getAllHashtags();
        for (Hashtag hashtag : hashtags) {
            hashtagDao.deleteHashtag(hashtag.getId());
        }

    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getUserById method, of class UserDaoDB.
     */
    @Test
    public void testAddGetUserById() {

        Role role = new Role();
        role.setRole("testRole");
        role = roleDao.createRole(role);

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setFirstName("testname");
        user.setLastName("testlast");
        user.setEnabled(true);
        user.setPassword("testpw");
        user.setPhoneNum("9292456342");
        user.setUserName("krmdlk");
        user.setRoles(roles);

        user = userDao.createUser(user);

        User fromDao = userDao.getUserById(user.getId());
        assertEquals(user, fromDao);

    }

    /**
     * Test of getUserByUserName method, of class UserDaoDB.
     */
    @Test
    public void testAddGetUserByUserName() {
        Role role = new Role();
        role.setRole("testRole");
        role = roleDao.createRole(role);

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setFirstName("testname");
        user.setLastName("testlast");
        user.setEnabled(true);
        user.setPassword("testpw");
        user.setPhoneNum("9292456342");
        user.setUserName("yooramachi");
        user.setRoles(roles);

        user = userDao.createUser(user);
        User fromDao = userDao.getUserByUserName(user.getUserName());
        assertEquals(user, fromDao);

    }

    /**
     * Test of getAllUsers method, of class UserDaoDB.
     */
    @Test
    public void testGetAllUsers() {
        Role role = new Role();
        role.setRole("testRole");
        role = roleDao.createRole(role);

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setFirstName("testname");
        user.setLastName("testlast");
        user.setEnabled(true);
        user.setPassword("testpw");
        user.setPhoneNum("9292456342");
        user.setUserName("Karma");
        user.setRoles(roles);

        user = userDao.createUser(user);

        User user1 = new User();
        user1.setFirstName("testname");
        user1.setLastName("testlast");
        user1.setEnabled(true);
        user1.setPassword("testpw");
        user1.setPhoneNum("9292456342");
        user1.setUserName("Dolkar");
        user1.setRoles(roles);

        user1 = userDao.createUser(user1);

        List<User> users = userDao.getAllUsers();

        assertEquals(2, users.size());
        assertTrue(users.contains(user));
        assertTrue(users.contains(user1));
    }

    /**
     * Test of updateUser method, of class UserDaoDB.
     */
    @Test
    public void testUpdateUser() {
        Role role = new Role();
        role.setRole("testRole");
        role = roleDao.createRole(role);

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setFirstName("testname");
        user.setLastName("testlast");
        user.setEnabled(true);
        user.setPassword("testpw");
        user.setPhoneNum("9292456342");
        user.setUserName("Karma");
        user.setRoles(roles);

        user = userDao.createUser(user);
        User fromDao = userDao.getUserById(user.getId());

        assertEquals(user, fromDao);

        user.setFirstName("Newtestname");
        user.setLastName("Newtestlast");
        user.setEnabled(true);
        user.setPassword("Newtestpw");
        user.setPhoneNum("9292456342");
        user.setUserName("NewKarma");
        user.setRoles(roles);

        userDao.updateUser(user);

        assertNotEquals(user, fromDao);
        fromDao = userDao.getUserById(user.getId());

        assertEquals(user, fromDao);

    }

    /**
     * Test of deleteUser method, of class UserDaoDB.
     */
    @Test
    public void testDeleteUser() {
        Role role = new Role();
        role.setRole("testRole");
        role = roleDao.createRole(role);

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setFirstName("testname");
        user.setLastName("testlast");
        user.setEnabled(true);
        user.setPassword("testpw");
        user.setPhoneNum("9292456342");
        user.setUserName("KozieMozie");
        user.setRoles(roles);

        user = userDao.createUser(user);
        
        User fromDao = userDao.getUserById(user.getId());
        
        assertEquals(user, fromDao);
        userDao.deleteUser(user.getId());
        fromDao = userDao.getUserById(user.getId());
        
        assertNull(fromDao);

    }
}
