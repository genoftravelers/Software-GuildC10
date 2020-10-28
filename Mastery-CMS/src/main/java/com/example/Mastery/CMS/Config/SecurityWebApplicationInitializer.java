/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Mastery.CMS.Config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */

//This file is what forces our application to load up and use our `SecurityConfig`. 
//We don't need to make any other changes to this file, just by existing it will let Spring Security know what to do.
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    
}
