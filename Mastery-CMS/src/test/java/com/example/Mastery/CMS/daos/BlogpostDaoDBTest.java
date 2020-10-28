/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.daos;

import com.example.Mastery.CMS.dtos.Blogpost;
import com.example.Mastery.CMS.dtos.Role;
import com.example.Mastery.CMS.dtos.User;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
public class BlogpostDaoDBTest {

    @Autowired
    BlogpostDao blogpostDao;

    @Autowired
    UserDao userDao;

    @Autowired
    HashtagDao hashtagDao;

    @Autowired
    RoleDao roleDao;

    public BlogpostDaoDBTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
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
        //remove all Role
        List<Role> roles = roleDao.getAllRoles();
        for (Role role : roles) {
            roleDao.deleteRole(role.getId());
        }

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getBlogPostById method, of class BlogpostDaoDB.
     */
    @Test
    public void testAddAndGetBlogPostById() {

        Role role = new Role();
        role.setRole("Admin");
        role = roleDao.createRole(role);
        
        Set <Role> roles = new HashSet <>();
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

        Blogpost blogpost = new Blogpost();

        blogpost.setBlogContent("TestFirst");
        blogpost.setBlogDate(LocalDateTime.now().withNano(0));
        blogpost.setExpiration(LocalDateTime.now().withNano(0));
        blogpost.setTitle("Test Title");
        blogpost.setIsStatic(true);
        blogpost.setIsVerified(true);
        blogpost.setUserId(user.getId());
        
        blogpost = blogpostDao.createBlogpost(blogpost);

        Blogpost fromDao = blogpostDao.getBlogPostById(blogpost.getId());
        assertEquals(blogpost, fromDao);

    }

    /**
     * Test of getBlogpostByTitle method, of class BlogpostDaoDB.
     */
    @Test
    public void testGetBlogpostByTitle() {
        Role role = new Role();
        role.setRole("Admin");
        role = roleDao.createRole(role);
        
        Set <Role> roles = new HashSet <>();
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

        Blogpost blogpost = new Blogpost();

        blogpost.setBlogContent("TestFirst");
        blogpost.setBlogDate(LocalDateTime.now().withNano(0));
        blogpost.setExpiration(LocalDateTime.now().withNano(0));
        blogpost.setTitle("Test Title");
        blogpost.setIsStatic(true);
        blogpost.setIsVerified(true);
        blogpost.setUserId(user.getId());
        
        blogpost = blogpostDao.createBlogpost(blogpost);
        Blogpost fromDao = blogpostDao.getBlogpostByTitle(blogpost.getTitle());
        assertEquals(blogpost, fromDao);
    }

    /**
     * Test of getAllBlogposts method, of class BlogpostDaoDB.
     */
    @Test
    public void testGetAllBlogposts() {
        Role role = new Role();
        role.setRole("Admin");
        role = roleDao.createRole(role);
        
        Set <Role> roles = new HashSet <>();
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

        Blogpost blogpost = new Blogpost();

        blogpost.setBlogContent("TestFirst");
        blogpost.setBlogDate(LocalDateTime.now().withNano(0));
        blogpost.setExpiration(LocalDateTime.now().withNano(0));
        blogpost.setTitle("Test Title");
        blogpost.setIsStatic(true);
        blogpost.setIsVerified(true);
        blogpost.setUserId(user.getId());
        
        blogpost = blogpostDao.createBlogpost(blogpost);

        Blogpost blogpost1 = new Blogpost();

        blogpost1.setBlogContent("TestFirst");
        blogpost1.setBlogDate(LocalDateTime.now().withNano(0));
        blogpost1.setExpiration(LocalDateTime.now().withNano(0));
        blogpost1.setTitle("Test Title");
        blogpost1.setIsStatic(true);
        blogpost1.setIsVerified(true);
        blogpost1.setUserId(user.getId());
        
        blogpost1 = blogpostDao.createBlogpost(blogpost1);
        
        List<Blogpost> blogposts = blogpostDao.getAllBlogposts();
        assertEquals(2, blogposts.size());
        assertTrue(blogposts.contains(blogpost));
        assertTrue(blogposts.contains(blogpost1));
    }

    /**
     * Test of deleteBlogpost method, of class BlogpostDaoDB.
     */
    @Test
    public void testDeleteBlogpost() {
        Role role = new Role();
        role.setRole("Admin");
        role = roleDao.createRole(role);
        
        Set <Role> roles = new HashSet <>();
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
        Blogpost blogpost = new Blogpost();

        blogpost.setBlogContent("TestFirst");
        blogpost.setBlogDate(LocalDateTime.now().withNano(0));
        blogpost.setExpiration(LocalDateTime.now().withNano(0));
        blogpost.setTitle("Test Title");
        blogpost.setIsStatic(true);
        blogpost.setIsVerified(true);
        blogpost.setUserId(user.getId());
        
        blogpost = blogpostDao.createBlogpost(blogpost);
        Blogpost fromDao = blogpostDao.getBlogPostById(blogpost.getId());
        
        assertEquals(blogpost, fromDao);
        blogpostDao.deleteBlogpost(blogpost.getId());
        fromDao = blogpostDao.getBlogPostById(blogpost.getId());
        
        assertNull(fromDao);
        
        
        
    }

    /**
     * Test of updateBlogpost method, of class BlogpostDaoDB.
     */
    @Test
    public void testUpdateBlogpost() {
        Role role = new Role();
        role.setRole("Admin");
        role = roleDao.createRole(role);
        
        Set <Role> roles = new HashSet <>();
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
        Blogpost blogpost = new Blogpost();

        blogpost.setBlogContent("TestFirst");
        blogpost.setBlogDate(LocalDateTime.now().withNano(0));
        blogpost.setExpiration(LocalDateTime.now().withNano(0));
        blogpost.setTitle("Test Title");
        blogpost.setIsStatic(true);
        blogpost.setIsVerified(true);
        blogpost.setUserId(user.getId());
        
        blogpost = blogpostDao.createBlogpost(blogpost);
        Blogpost fromDao = blogpostDao.getBlogPostById(blogpost.getId());
        
        assertEquals(blogpost, fromDao);
        
        
        blogpost.setBlogContent("NewTestFirst");
        blogpost.setBlogDate(LocalDateTime.now().withNano(0));
        blogpost.setExpiration(LocalDateTime.now().withNano(0));
        blogpost.setTitle("New Test Title");
        blogpost.setIsStatic(true);
        blogpost.setIsVerified(true);
        blogpost.setUserId(user.getId());
       
        blogpostDao.updateBlogpost(blogpost);
        
        assertNotEquals(blogpost, fromDao);
        fromDao = blogpostDao.getBlogPostById(blogpost.getId());
        
        assertEquals(blogpost, fromDao);
        
        
        
    }

   

}
