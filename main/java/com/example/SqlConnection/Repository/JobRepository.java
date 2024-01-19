package com.example.SqlConnection.Repository;

import com.example.SqlConnection.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

//    Job findByRole(String role);

}
