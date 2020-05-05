package com.example.mstu5031finalproject.entity;

import java.util.Date;

public class Course {
    public String courseNumber;
    public String courseName;
    public String courseIntro;
    public String credit;
    public String seatRemain;
    public String room;
    public String courseTime;
    public String instructor;

    public Course(String courseNumber, String courseName, String courseIntro) {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.courseIntro = courseIntro;
    }

    public Course(String courseNumber, String courseName, String courseIntro, String credit, String seatRemain, String room, String courseTime) {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.courseIntro = courseIntro;
        this.credit = credit;
        this.seatRemain = seatRemain;
        this.room = room;
        this.courseTime = courseTime;
    }

    public Course(String courseNumber, String courseName, String credit, String room, String courseTime, String instructor) {
        this.courseNumber = courseNumber;
        this.courseName = courseName;
        this.credit = credit;
        this.room = room;
        this.courseTime = courseTime;
        this.instructor = instructor;
    }

    @Override
    public String toString(){
        return "courseNumber: " + courseNumber +
                "\n courseName:" + courseName +
                "\n courseIntro:" + courseIntro +
                "\n credit:" + credit +
                "\n room:" + room +
                "\n courseTime:" + courseTime +
                "\n instructor:" + instructor;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseIntro() {
        return courseIntro;
    }

    public void setCourseIntro(String courseIntro) {
        this.courseIntro = courseIntro;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getSeatRemain() {
        return seatRemain;
    }

    public void setSeatRemain(String seatRemain) {
        this.seatRemain = seatRemain;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
