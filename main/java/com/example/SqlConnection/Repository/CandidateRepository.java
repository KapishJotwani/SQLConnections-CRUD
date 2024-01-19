package com.example.SqlConnection.Repository;

import com.example.SqlConnection.Entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findByName(String name);
}

