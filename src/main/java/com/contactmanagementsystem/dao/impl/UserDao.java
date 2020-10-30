/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.dao.impl;

import com.contactmanagementsystem.dao.IUserDao;
import com.contactmanagementsystem.models.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dagy
 */
public class UserDao extends Dao<User, Long> implements IUserDao {

    private final String createStatement = "insert into user (first_name,last_name,username,password,picture) values (?,?,?,?,?)";
    private final String updateStatement = "update user set first_name=? ,last_name=? ,username=? ,password=? ,picture=? where id=?";
    private final String deleteStatement = "delete from user where id=?";
    private final String findAllStatement = "select * from user";
    private final String findLastStatement = "select * from user order by id desc";
    private final String findByIdStatement = "select * from user where id = ? ";
    private final String findByUserNameStatement = "SELECT * FROM user WHERE username LIKE ?";

    @Override
    public Boolean creat(User t) {
        int executeUpdate = -1;
        this.createPreparedStatement(createStatement);
        try {
            preparedStatement.setString(1, t.getFirstName());
            preparedStatement.setString(2, t.getLastName());
            preparedStatement.setString(3, t.getUserName());
            preparedStatement.setString(4, t.getPassword());
            preparedStatement.setString(5, t.getPicture());
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeUpdate > 0;
    }

    @Override
    public Boolean update(User t) {
        int executeUpdate = -1;
        this.createPreparedStatement(updateStatement);
        try {
            preparedStatement.setString(1, t.getFirstName());
            preparedStatement.setString(2, t.getLastName());
            preparedStatement.setString(3, t.getUserName());
            preparedStatement.setString(4, t.getPassword());
            preparedStatement.setString(5, t.getPicture());
            preparedStatement.setLong(6, t.getId());
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeUpdate > 0;
    }

    @Override
    public boolean delete(User t) {
        int executeUpdate = -1;
        this.createPreparedStatement(deleteStatement);
        try {
            preparedStatement.setLong(1, t.getId());
            executeUpdate = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeUpdate > 0;
    }

    @Override
    public List<User> findAll() {
        List<User> users = null;
        this.createPreparedStatement(findAllStatement);

        try {
            ResultSet rs = preparedStatement.executeQuery();
            users = new LinkedList<>();
            while (rs.next()) {
                Long id = rs.getLong("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                String picture = rs.getString("picture");
                users.add(new User(id, firstName, lastName, userName, password, picture));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return users;
    }

    @Override
    public User findById(Long id) {
        User user = null;
        this.createPreparedStatement(findByIdStatement);
        try {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = new User(
                        rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("user_name"),
                        rs.getString("password"),
                        rs.getString("picture")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = null;
        this.createPreparedStatement(findByUserNameStatement);
        try {
            //preparedStatement.setString(1, "%"+ username +"%");
            preparedStatement.setString(1, "%" + username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                user = new User(
                        rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("user_name"),
                        rs.getString("password"),
                        rs.getString("picture")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return user;
    }

}
