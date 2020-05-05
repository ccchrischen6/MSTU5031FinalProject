package com.example.mstu5031finalproject.entity;

import android.app.Application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class User extends Application {
    private String userName;
    private String profileUrl;
    private Map<String, Course> regCourses = new HashMap<>();

    public User(){}

    public User(String userName, String profileUrl) {
        this.userName = userName;
        this.profileUrl = profileUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public Map<String, Course> getRegCourses() {
        return regCourses;
    }
}
