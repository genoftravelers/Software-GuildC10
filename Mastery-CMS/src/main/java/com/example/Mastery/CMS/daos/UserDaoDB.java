/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.daos;

import com.example.Mastery.CMS.daos.RoleDaoDB.RoleMapper;
import com.example.Mastery.CMS.dtos.Role;
import com.example.Mastery.CMS.dtos.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@Repository
public class UserDaoDB implements UserDao{
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public User getUserById(int id) {
        try {
            final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE userId = ?";
            User user = jdbc.queryForObject(SELECT_USER_BY_ID, new UserMapper(), id);
            user.setRoles(getRolesForUser(user.getId()));
            return user;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public User getUserByUserName(String username) {
        try {
            final String SELECT_USER_BY_USERNAME = "SELECT * FROM user WHERE userName = ?";
            User user = jdbc.queryForObject(SELECT_USER_BY_USERNAME, new UserMapper(), username);
            user.setRoles(getRolesForUser(user.getId()));
            return user;
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        final String SELECT_ALL_USERS = "SELECT * FROM user";
        
        List<User> users = jdbc.query(SELECT_ALL_USERS, new UserMapper());
        for (User user : users) {
            user.setRoles(getRolesForUser(user.getId()));
        }
        return users;
    }

    private Set<Role> getRolesForUser(int id) throws DataAccessException {
        final String SELECT_ROLES_FOR_USER = "SELECT r.* FROM userRole ur "
                + "JOIN role r ON ur.roleId = r.roleId "
                + "WHERE ur.userId = ?";
        Set<Role> roles = new HashSet(jdbc.query(SELECT_ROLES_FOR_USER, new RoleMapper(), id));
        return roles;
    }

    @Override
    public void updateUser(User user) {
        final String UPDATE_USER = "UPDATE user SET userName = ?, firstName = ?, lastName = ?, password = ?, enabled = ?, phoneNum = ? WHERE userId = ?";
        jdbc.update(UPDATE_USER,
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.isEnabled(),
                user.getPhoneNum(),
                user.getId());

        
        
        final String DELETE_USER_ROLE = "DELETE FROM userRole WHERE userId = ?";
        jdbc.update(DELETE_USER_ROLE, user.getId());
        
        for (Role role : user.getRoles()) {
            final String INSERT_USER_ROLE = "INSERT INTO userRole(userId, roleId) VALUES(?,?)";
            jdbc.update(INSERT_USER_ROLE, user.getId(), role.getId());
        }
    }

    @Override
    public void deleteUser(int id) {
        final String DELETE_USER_ROLE = "DELETE FROM userRole WHERE userId = ?";
        final String DELETE_USER = "DELETE FROM user WHERE userId = ?";
        jdbc.update(DELETE_USER_ROLE, id);
        jdbc.update(DELETE_USER, id);
    }

    @Override
    @Transactional
    public User createUser(User user) {
        final String INSERT_USER = "INSERT INTO user(username, firstName, lastName, password, enabled, phoneNum) VALUES(?,?,?,?,?,?)";
        jdbc.update(INSERT_USER,
                user.getUserName(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.isEnabled(),
                user.getPhoneNum());
        
        int newId = jdbc.queryForObject("select LAST_INSERT_ID()", Integer.class);
        user.setId(newId);

        for (Role role : user.getRoles()) {
            final String INSERT_USER_ROLE = "INSERT INTO userRole(userId, roleId) VALUES(?,?)";
            jdbc.update(INSERT_USER_ROLE, user.getId(), role.getId());
        }
        return user;
    }

    public static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("userId"));
            user.setUserName(rs.getString("userName"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setPassword(rs.getString("password"));
            user.setEnabled(rs.getBoolean("enabled"));
            user.setPhoneNum(rs.getString("phoneNum"));
            return user;
        }
    }

}
