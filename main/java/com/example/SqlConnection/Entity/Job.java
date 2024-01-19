package com.example.SqlConnection.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Job {
    @Id
    private Long j_id;



    private String j_role;

    private String j_company;

    public Long getJ_id() {
        return j_id;
    }

    public void setJ_id(Long j_id) {
        this.j_id = j_id;
    }

    public String getJ_role() {
        return j_role;
    }

    public void setJ_role(String j_role) {
        this.j_role = j_role;
    }

    public String getJ_company() {
        return j_company;
    }

    public void setJ_company(String j_company) {
        this.j_company = j_company;
    }
}
