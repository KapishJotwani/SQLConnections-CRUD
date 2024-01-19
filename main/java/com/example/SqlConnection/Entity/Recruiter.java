package com.example.SqlConnection.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Recruiter {

    @Id
    private Long rec_id;

    private String rec_name;

    private String rec_email;

    private long rec_phone_num;

    public Long getRec_id() {
        return rec_id;
    }

    public void setRec_id(Long rec_id) {
        this.rec_id = rec_id;
    }

    public String getRec_name() {
        return rec_name;
    }

    public void setRec_name(String rec_name) {
        this.rec_name = rec_name;
    }

    public String getRec_email() {
        return rec_email;
    }

    public void setRec_email(String rec_email) {
        this.rec_email = rec_email;
    }

    public long getRec_phone_num() {
        return rec_phone_num;
    }

    public void setRec_phone_num(long rec_phone_num) {
        this.rec_phone_num = rec_phone_num;
    }
}
