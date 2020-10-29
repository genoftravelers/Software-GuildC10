/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.daos;

import com.example.Mastery.CMS.dtos.User;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface UserDao {

    User getUserById(int id);

    User getUserByUserName(String userName);

    List<User> getAllUsers();

    void updateUser(User user);

    void deleteUser(int id);

    User createUser(User user);
}
