/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dagy
 */
public class ConnectionDao {

    //Information de connexion � la base de donn�es
    static String url = "jdbc:mysql://localhost:3306/db_contact_management_system";
    static String user = "root";
    static String pass = "root";

    private static Connection connect = null;

    public ConnectionDao(){
        try {

            this.connect = DriverManager.getConnection(url, user, pass);
            System.out.println("connection reussie");	

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (connect == null) {
            new ConnectionDao();
        }
        return connect;

    }

}
