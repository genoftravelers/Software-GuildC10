/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.daos;

import com.example.Mastery.CMS.dtos.Role;
import java.util.List;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
public interface RoleDao {

    Role getRoleById(int id);

    Role getRoleByRole(String role);

    List<Role> getAllRoles();

    void deleteRole(int id);

    void updateRole(Role role);

    Role createRole(Role role);

}
