package com.example.SqlConnection.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Interview {

    @Id
    private Long int_id;

    private String int_mode;

    private String int_date;

    private String int_result;

    public Long getInt_id() {
        return int_id;
    }

    public void setInt_id(Long int_id) {
        this.int_id = int_id;
    }

    public String getInt_mode() {
        return int_mode;
    }

    public void setInt_mode(String int_mode) {
        this.int_mode = int_mode;
    }

    public String getInt_date() {
        return int_date;
    }

    public void setInt_date(String int_date) {
        this.int_date = int_date;
    }

    public String getInt_result() {
        return int_result;
    }

    public void setInt_result(String int_result) {
        this.int_result = int_result;
    }


}
