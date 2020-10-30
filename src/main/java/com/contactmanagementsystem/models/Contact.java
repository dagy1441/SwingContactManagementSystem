/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactmanagementsystem.models;

/**
 *
 * @author dagy
 */
public class Contact {

    private Long id;
    private String firstName;
    private String lastName;
    private String contactGroup;
    private String phone;
    private String email;
    private String address;
    private byte[] picture;
    private int userId;

    public Contact() {
    }

    public Contact(Long id, String firstName, String lastName, String contactGroup, String phone, String email, String address, byte[] picture) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactGroup = contactGroup;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.picture = picture;
    }
    
    

    public Contact(Long id, String firstName, String lastName, String contactGroup, String phone, String email, String address, byte[] picture, int userId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactGroup = contactGroup;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.picture = picture;
        this.userId = userId;
    }

   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(String contactGroup) {
        this.contactGroup = contactGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    

}
