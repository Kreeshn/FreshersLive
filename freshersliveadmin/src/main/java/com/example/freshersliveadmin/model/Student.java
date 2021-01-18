package com.example.freshersliveadmin.model;

public class Student {
    private int sid;
    private String fname;
    private String lname;
    private String dob;
    private String gender;
    private String contact;
    private String email;
    private String skills;

    public Student(int sid, String fname, String lname, String dob, String gender, String contact, String email, String skills) {
        this.sid = sid;
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.gender = gender;
        this.contact = contact;
        this.email = email;
        this.skills = skills;
    }

    public int getSid() {
        return sid;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getSkills() {
        return skills;
    }
}
