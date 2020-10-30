/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.dao.impl;

import com.contactmanagementsystem.dao.ConnectionDao;
import com.contactmanagementsystem.dao.IDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dagy
 * @param <T>
 * @param <ID>
 */
public abstract class Dao<T, ID> implements IDao<T, ID> {

    protected Connection connection;
    PreparedStatement preparedStatement = null;

    public Dao() {
        this.connection = ConnectionDao.getConnection();
    }

    public PreparedStatement createPreparedStatement(String statement) {
        try {
            preparedStatement = connection.prepareStatement(statement);
        } catch (SQLException ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return preparedStatement;
    }

}
