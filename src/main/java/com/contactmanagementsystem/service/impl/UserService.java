/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.service.impl;

import com.contactmanagementsystem.dao.IUserDao;
import com.contactmanagementsystem.dao.impl.UserDao;
import com.contactmanagementsystem.models.User;
import com.contactmanagementsystem.service.IUserService;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dagy
 */
public class UserService extends AppService<User, Long> implements IUserService {
    
    public IUserDao userDao = null;
    
    public UserService(){
        
        this.userDao = new UserDao();
    }

    @Override
    public String browseImage(JLabel label) {
        return super.browseImage(label); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ImageIcon resizeImage(String imagePath, byte[] blopPic, int width, int height) {
        return super.resizeImage(imagePath,blopPic, width, height); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean creat(User t) {
        return userDao.creat(t);
    }

    @Override
    public Boolean update(User t) {
        return userDao.update(t);
    }

    @Override
    public boolean delete(User t) {
        return userDao.delete(t);
    }

    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

   

    

}
