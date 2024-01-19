package com.example.SqlConnection.Repository;

import com.example.SqlConnection.Entity.Interviewer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewerRepository extends JpaRepository<Interviewer, Long> {

    /*Interviewer findByName(String i_name);*/


}
