package com.example.a38_nguyenngocanh_02122019;

import java.io.Serializable;

public class Contact implements Serializable {

    private String name;
    private String number;
    private String address;
    private int image;

    public Contact(String name, String number, String address, int image) {
        this.name = name;
        this.number = number;
        this.address = address;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
