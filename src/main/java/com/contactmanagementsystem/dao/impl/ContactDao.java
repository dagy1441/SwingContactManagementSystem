/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.dao.impl;

import com.contactmanagementsystem.dao.IContactDao;
import com.contactmanagementsystem.models.Contact;
import com.contactmanagementsystem.service.impl.ContactService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dagy
 */
public class ContactDao extends Dao<Contact, Long> implements IContactDao {

//    "SELECT `id`, `first_name`, `last_name`, `contact_group`, `phone`, `email`,`address`, `picture` , `user_id` FROM `contact` WHERE user_id= "
    private final String createStatement = "INSERT INTO contact (first_name,last_name,phone,email,contact_group,address,picture, user_id) values (?,?,?,?,?,?,?, ?)";
    private final String updateStatement = "UPDATE contact SET first_name=? ,last_name=? ,contact_group=? ,phone=? ,email=? ,address=? ,picture=? ,user_id=? WHERE id=?";
    private final String deleteStatement = "DELETE FROM contact where id=?";
    private final String findAllStatement = "SELECT `id`, `first_name`, `last_name`, `contact_group`, `phone`, `email`,`address`, `picture`  FROM contact";
    private final String findLastStatement = "SELECT * FROM contact ORDER BY id DESC";
    private final String findByIdStatement = "SELECT * FROM contact WHERE id = ? ";
    private final String findContactByUserIdStatement = "SELECT `id`, `first_name`, `last_name`, `contact_group`, `phone`, `email`,`address`, `picture` , `user_id` FROM `contact` WHERE user_id = ?";
    private final String findByPhoneStatement = "SELECT * FROM contact where phone = ? ";
    private final String findByEmailStatement = "SELECT * FROM contact where phone = ? ";
    private final String findContactByFirstNameAndLastNameStatement = "SELECT * FROM contact where first_name = ? AND last_name = ? ";
    private final String findContactIdExistStatement = "SELECT * FROM contact where id = ? ";

    private final String findByFirstNameORLastNameStatement = "SELECT * FROM contact WHERE first_name LIKE ? OR last_name LIKE ?";

    @Override
    public Boolean creat(Contact t) {
        boolean contactIsCreated = true;
        this.createPreparedStatement(createStatement);
        try {
            preparedStatement.setString(1, t.getFirstName());
            preparedStatement.setString(2, t.getLastName());
            preparedStatement.setString(3, t.getPhone());
            preparedStatement.setString(4, t.getEmail());
            preparedStatement.setString(5, t.getContactGroup());
            preparedStatement.setString(6, t.getAddress());
            preparedStatement.setBytes(7, t.getPicture());
            preparedStatement.setInt(8, t.getUserId());

            if (preparedStatement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "New contact added");
                contactIsCreated = true;
            } else {
                JOptionPane.showMessageDialog(null, "Something wrong");
                contactIsCreated = false;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContactDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contactIsCreated;
    }

    @Override
    public Boolean update(Contact t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Contact t) {
        boolean contactIsCreated = true;
        this.createPreparedStatement(createStatement);
        
        try {
            preparedStatement.setLong(1, t.getId());
            
            if (preparedStatement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Contact data deleted !");
                contactIsCreated = true;

            } else {
                JOptionPane.showMessageDialog(null, "Something wrong !");
                contactIsCreated = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contactIsCreated;
    }

    @Override
    public Contact findById(Long id) {
        Contact contact = null;
        this.createPreparedStatement(findByIdStatement);
        try {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                contact = new Contact(
                        rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("contact_group"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getBytes("picture")
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return contact;
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> contacts = null;
        Contact contact;
        this.createPreparedStatement(findAllStatement);

        try {
            ResultSet rs = preparedStatement.executeQuery();
            contacts = new ArrayList<>();
            while (rs.next()) {
                contact = new Contact(rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("contact_group"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getBytes("picture"),
                        0);
                contacts.add(contact);
                //                Long id = rs.getLong("id");
                //                String firstName = rs.getString("first_name");
                //                String lastName = rs.getString("last_name");
                //                String contactGroup = rs.getString("contact_group");
                //                String phone = rs.getString("phone");
                //                String email = rs.getString("email");
                //                String address = rs.getString("address");
                //                byte[] picture = rs.getBytes("picture");
                //                contacts.add(new Contact(id, firstName, lastName, contact_group, phone, email,picture));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return contacts;
    }

    @Override
    public String findByFirstNameORLastName(String name, String lastname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String findByPhoneNumber(String phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> findContactByUserId(int userId) {
        List<Contact> contacts = new ArrayList<>();
        try {
            this.createPreparedStatement(findContactByUserIdStatement);
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            Contact contact;
            while (rs.next()) {
                contact = new Contact(
                        rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("contact_group"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getBytes("picture"),
                        rs.getInt("user_id")
                //userId
                );
                contacts.add(contact);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);

        }

//        try {
//            ResultSet rs = preparedStatement.executeQuery();
//            contacts = new ArrayList<>();
//            while (rs.next()) {
//                contact = new Contact(
//                        rs.getLong("id"),
//                        rs.getString("first_name"),
//                        rs.getString("last_name"),
//                        rs.getString("contact_group"),
//                        rs.getString("phone"),
//                        rs.getString("email"),
//                        rs.getString("address"),
//                        rs.getBytes("picture"),
//                        rs.getInt("user_id")
//                        );
//                contacts.add(contact);
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return contacts;
    }

    @Override
    public boolean findContactExist(String firstName, String lastName) {
             boolean userExist = false;
        this.createPreparedStatement(findContactByFirstNameAndLastNameStatement);
        try {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                userExist = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return userExist;
    }

    @Override
    public boolean findContactIdExist(Long id) {
             boolean userExist = false;
        this.createPreparedStatement(findContactIdExistStatement);
        try {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                rs.getLong("id");
                userExist = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return userExist;
    }

}
