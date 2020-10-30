/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.service.impl;

import com.contactmanagementsystem.dao.ConnectionDao;
import com.contactmanagementsystem.dao.IContactDao;
import com.contactmanagementsystem.dao.impl.ContactDao;
import com.contactmanagementsystem.models.Contact;
import com.contactmanagementsystem.service.IContactService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dagy
 */
public class ContactService extends AppService<Contact, Long> implements IContactService {

    public IContactDao contactDao = null;

    public ContactService() {
        contactDao = new ContactDao();
    }

    @Override
    public Boolean creat(Contact t) {
        return contactDao.creat(t);
    }

    @Override
    public Boolean update(Contact t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Contact t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contact findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> findAll() {
        return contactDao.findAll();
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
        return contactDao.findContactByUserId(userId);
    }

    public List<Contact> contactList(int userId) {
        ArrayList<Contact> listContact = new ArrayList<>();

        Connection con = ConnectionDao.getConnection();
        Statement st;
        ResultSet rs;

        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT `id`, `first_name`, `last_name`, `contact_group`, `phone`, `email`,`address`, `picture` FROM `contact` WHERE user_id= " + userId);
            Contact contact;
            while (rs.next()) {
                contact = new Contact(rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("contact_group"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getBytes("picture"),
                        userId);
                listContact.add(contact);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ContactService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listContact;
    }

    public void updateContact(Contact contact, boolean withImage) {
        Connection con = ConnectionDao.getConnection();
        PreparedStatement preparedStatement;
        ResultSet rs;

        String updateQuery = "";

        if (withImage == true) { // if the user want to update the image

            updateQuery = "UPDATE contact SET first_name=? ,last_name=? ,contact_group=? ,phone=? ,email=? ,address=? ,picture=? WHERE id=?";
        
            try {
                preparedStatement = con.prepareStatement(updateQuery);
                preparedStatement.setString(1, contact.getFirstName());
                preparedStatement.setString(2, contact.getLastName());
                preparedStatement.setString(3, contact.getPhone());
                preparedStatement.setString(4, contact.getEmail());
                preparedStatement.setString(5, contact.getContactGroup());
                preparedStatement.setString(6, contact.getAddress());
                preparedStatement.setBytes(7, contact.getPicture());
                preparedStatement.setLong(8, contact.getId());

            if (preparedStatement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Contact data updated !");

            } else {
                JOptionPane.showMessageDialog(null, "Something wrong !");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        } else { // if the user keep to update [ remove the image from the update ]
            updateQuery = "UPDATE contact SET first_name=? ,last_name=? ,contact_group=? ,phone=? ,email=? ,address=? WHERE id=?";
        
            try {
             preparedStatement = con.prepareStatement(updateQuery);
                preparedStatement.setString(1, contact.getFirstName());
                preparedStatement.setString(2, contact.getLastName());
                preparedStatement.setString(3, contact.getPhone());
                preparedStatement.setString(4, contact.getEmail());
                preparedStatement.setString(5, contact.getContactGroup());
                preparedStatement.setString(7, contact.getAddress());
            preparedStatement.setLong(7, contact.getId());

            if (preparedStatement.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, " Contact data updated ! ");

            } else {
                JOptionPane.showMessageDialog(null, "Something wrong !");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactService.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

        
    }

    public void deleteContact(Long id){
        Connection con = ConnectionDao.getConnection();
        PreparedStatement ps;
        String sql = "DELETE FROM `contact` WHERE `id` = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            
            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Contact data deleted !");

            } else {
                JOptionPane.showMessageDialog(null, "Something wrong !");

            }
        } catch (SQLException ex) {
            Logger.getLogger(ContactService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean findContactExist(String firstName, String lastName) {

        return contactDao.findContactExist(firstName, lastName);
    }

    @Override
    public boolean findContactIdExist(Long id) {

        return contactDao.findContactIdExist(id);
    }

}
