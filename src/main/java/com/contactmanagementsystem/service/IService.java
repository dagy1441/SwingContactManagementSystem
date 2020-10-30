/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.service;

import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author dagy
 */
public interface IService<T, ID> {
    
    public Boolean creat(T t);
    
    public Boolean update(T t);
    
    public boolean delete(T t);
    
    public T findById(ID id);
    
    public List<T> findAll();
    
    
}
