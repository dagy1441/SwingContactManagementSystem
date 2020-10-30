/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.dao;

import com.contactmanagementsystem.models.Contact;
import java.util.List;

/**
 *
 * @author dagy
 */
public interface IContactDao extends IDao<Contact, Long>{
    
    public List<Contact> findContactByUserId(int userId);
    
    public String findByFirstNameORLastName(String name, String lastname);
    
    public String findByPhoneNumber(String phone);
    
    public boolean findContactExist(String firstName, String lastName);
    
    public boolean findContactIdExist(Long id);
        
}
