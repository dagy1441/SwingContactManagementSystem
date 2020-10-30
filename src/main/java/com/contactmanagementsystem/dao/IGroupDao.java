/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.dao;

import com.contactmanagementsystem.models.Group;

/**
 *
 * @author dagy
 */
public interface IGroupDao extends IDao<Group, Long>{
    
    public Group fingByGroupName(String keyWord);
}
