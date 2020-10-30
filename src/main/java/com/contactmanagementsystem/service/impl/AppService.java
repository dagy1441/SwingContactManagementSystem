/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.service.impl;

import com.contactmanagementsystem.service.IService;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dagy
 */
public abstract class AppService<T, ID> implements IService<T, ID>{
     
    
    public ImageIcon resizeImage(String imagePath,byte[] blopPic,int width, int height) {

        ImageIcon myImage;
        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        }else{
            myImage = new ImageIcon(blopPic);
        }
        Image image = myImage.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon myPicture = new ImageIcon(image);
        return myPicture;
    }

    
    
    public String browseImage(JLabel label) {

        String path = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        // file extension
        FileNameExtensionFilter fileExtension = new FileNameExtensionFilter(
                "*.images", "jpg", "JPG", "jpeg", "JPEG", "png", "PNG", "gif");
        fileChooser.addChoosableFileFilter(fileExtension);
        int fileState = fileChooser.showSaveDialog(null);

        // if the user select a file
        if (fileState == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
             path = selectedFile.getAbsolutePath();
             
//            imagePath = path;
            // display the image in the jLabel using the resize image method
            label.setIcon(resizeImage(path, null, label.getWidth(), label.getHeight()));
//            label.setIcon(new ImageIcon(path));
            
        } else if (fileState == JFileChooser.CANCEL_OPTION) {
            // if the user cancel
            System.out.println("No image selected");
        }
        
        return path;
        
    }
}
