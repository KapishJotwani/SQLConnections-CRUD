package com.example.SqlConnection.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Interviewer {

    @Id
    private Long i_id;

    private String i_name;

    private String i_designation;

    private String i_email;

    private long i_phone_num;

    public Long getI_id() {
        return i_id;
    }

    public void setI_id(Long i_id) {
        this.i_id = i_id;
    }

    public String getI_name() {
        return i_name;
    }

    public void setI_name(String i_name) {
        this.i_name = i_name;
    }

    public String getI_designation() {
        return i_designation;
    }

    public void setI_designation(String i_designation) {
        this.i_designation = i_designation;
    }

    public String getI_email() {
        return i_email;
    }

    public void setI_email(String i_email) {
        this.i_email = i_email;
    }

    public long getI_phone_num() {
        return i_phone_num;
    }

    public void setI_phone_num(long i_phone_num) {
        this.i_phone_num = i_phone_num;
    }


}
