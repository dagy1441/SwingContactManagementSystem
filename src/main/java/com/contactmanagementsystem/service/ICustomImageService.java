/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.service;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author dagy
 */
public interface ICustomImageService {
    
    public ImageIcon resizeImage(String picPath, int width, int height);
    
    public void browseImage(JLabel label);
}
