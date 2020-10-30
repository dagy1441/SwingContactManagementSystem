/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.dao;

import java.util.List;

/**
 *
 * @author dagy
 * @param <T>
 * @param <ID>
 */
public interface IDao<T, ID> {
    
    public Boolean creat(T t);
    
    public Boolean update(T t);
    
    public boolean delete(T t);
    
    public T findById(ID id);
    
    public List<T> findAll();

}
