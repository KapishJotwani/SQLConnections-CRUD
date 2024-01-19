package com.example.SqlConnection.Repository;

import com.example.SqlConnection.Entity.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

//    Recruiter findByRec_name(String name);
}
