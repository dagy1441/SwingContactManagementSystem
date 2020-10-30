/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.service;

import com.contactmanagementsystem.models.User;

/**
 *
 * @author dagy
 */
public interface IUserService extends IService<User, Long> {

    public User findByUsername(String username);
}
