package com.example.fresherslivecompany.model;

import java.util.Date;

public class JobComp {
    private int job_id;
    private String profile;
    private  String parttime;
    private String work_type;
    private int opening;
    private Date start_date;
    private String duration;
    private String respo;
    private String sallaty_type;
    private String skill_required;
    private String ass1;
    private String ass2;
    private String co_name;
    private String co_desc;
    private String co_email;
    private String co_contact;
    private String co_page;
    private String co_web;

    public JobComp(int job_id, String profile, String parttime, String work_type, int opening, Date start_date, String duration, String respo, String sallaty_type, String skill_required, String ass1, String ass2, String co_name, String co_desc, String co_email, String co_contact, String co_page, String co_web) {
        this.job_id = job_id;
        this.profile = profile;
        this.parttime = parttime;
        this.work_type = work_type;
        this.opening = opening;
        this.start_date = start_date;
        this.duration = duration;
        this.respo = respo;
        this.sallaty_type = sallaty_type;
        this.skill_required = skill_required;
        this.ass1 = ass1;
        this.ass2 = ass2;
        this.co_name = co_name;
        this.co_desc = co_desc;
        this.co_email = co_email;
        this.co_contact = co_contact;
        this.co_page = co_page;
        this.co_web = co_web;
    }

    public int getJob_id() {
        return job_id;
    }

    public void setJob_id(int job_id) {
        this.job_id = job_id;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getParttime() {
        return parttime;
    }

    public void setParttime(String parttime) {
        this.parttime = parttime;
    }

    public String getWork_type() {
        return work_type;
    }

    public void setWork_type(String work_type) {
        this.work_type = work_type;
    }

    public int getOpening() {
        return opening;
    }

    public void setOpening(int opening) {
        this.opening = opening;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRespo() {
        return respo;
    }

    public void setRespo(String respo) {
        this.respo = respo;
    }

    public String getSallaty_type() {
        return sallaty_type;
    }

    public void setSallaty_type(String sallaty_type) {
        this.sallaty_type = sallaty_type;
    }

    public String getSkill_required() {
        return skill_required;
    }

    public void setSkill_required(String skill_required) {
        this.skill_required = skill_required;
    }

    public String getAss1() {
        return ass1;
    }

    public void setAss1(String ass1) {
        this.ass1 = ass1;
    }

    public String getAss2() {
        return ass2;
    }

    public void setAss2(String ass2) {
        this.ass2 = ass2;
    }

    public String getCo_name() {
        return co_name;
    }

    public void setCo_name(String co_name) {
        this.co_name = co_name;
    }

    public String getCo_desc() {
        return co_desc;
    }

    public void setCo_desc(String co_desc) {
        this.co_desc = co_desc;
    }

    public String getCo_email() {
        return co_email;
    }

    public void setCo_email(String co_email) {
        this.co_email = co_email;
    }

    public String getCo_contact() {
        return co_contact;
    }

    public void setCo_contact(String co_contact) {
        this.co_contact = co_contact;
    }

    public String getCo_page() {
        return co_page;
    }

    public void setCo_page(String co_page) {
        this.co_page = co_page;
    }

    public String getCo_web() {
        return co_web;
    }

    public void setCo_web(String co_web) {
        this.co_web = co_web;
    }
}
