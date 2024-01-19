package com.example.SqlConnection.Service;

import com.example.SqlConnection.Entity.Candidate;
import com.example.SqlConnection.Repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.jdbc.core.RowMapper;

@Service
public class CandidateService {

    private final JdbcTemplate jdbcTemplate;

    public CandidateService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate addCandidate(Candidate candidate){
        return candidateRepository.save(candidate);
    }

    public List<Candidate> addCandidated(List<Candidate> candidate){
        return candidateRepository.saveAll(candidate);
    }

    public List<Candidate> getCandidate(){
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long id){
        return candidateRepository.findById(id).orElse(null);
    }

    public Candidate getCandidateByName(String name){
        return candidateRepository.findByName(name);
    }

    public String deleteCandidate(Long id){
        candidateRepository.deleteById(id);
        return null;
    }


    public List<String> getCandidateColumns() {
        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'candidate' ORDER BY ORDINAL_POSITION";
        return jdbcTemplate.query(query, new ColumnNameMapper());

    }

    private static class ColumnNameMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return resultSet.getString("column_name");
        }
    }




    public Candidate updateCandidate(Candidate candidate){

        if (candidate.getId() == null) {
            throw new IllegalArgumentException("Candidate id cannot be null for update.");
        }

        // Fetch the existing candidate from the database
        Candidate existingCandidate = candidateRepository.findById(candidate.getId()).orElse(null);

        // Check if the candidate with the given id exists
        if (existingCandidate == null) {
            throw new NoSuchElementException("Candidate with id " + candidate.getId() + " not found.");
        }

        // Update the existing candidate with the new values
        existingCandidate.setName(candidate.getName());
        existingCandidate.setAddress(candidate.getAddress());
        existingCandidate.setQualification(candidate.getQualification());
        existingCandidate.setPhone_number(candidate.getPhone_number());
        existingCandidate.setSkills(candidate.getSkills());
        existingCandidate.setAge(candidate.getAge());

        // Save the updated candidate to the database
        return candidateRepository.save(existingCandidate);
    }


}
