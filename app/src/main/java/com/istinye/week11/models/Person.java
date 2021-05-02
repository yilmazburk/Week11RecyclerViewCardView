package com.istinye.week11.models;

import com.istinye.week11.utils.ViewUtil;

public class Person {

    private String name;
    private String surname;
    private int profilePictureId;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.profilePictureId = ViewUtil.getRandomProfilePicture();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getProfilePictureId() {
        return profilePictureId;
    }

    public void setProfilePictureId(int profilePictureId) {
        this.profilePictureId = profilePictureId;
    }
}
