package com.example.SqlConnection.Service;

import com.example.SqlConnection.Entity.Recruiter;
import com.example.SqlConnection.Repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.jdbc.core.RowMapper;

@Service
public class RecruiterService {
    @Autowired
    private RecruiterRepository recruiterRepository;

    private final JdbcTemplate jdbcTemplate;
    public RecruiterService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Recruiter addRecruiter(Recruiter recruiter){
        return recruiterRepository.save(recruiter);
    }

    public List<Recruiter> addRecruiterd(List<Recruiter> recruiter){
        return recruiterRepository.saveAll(recruiter);
    }

    public List<Recruiter> getRecruiter(){
        return recruiterRepository.findAll();
    }

    public Recruiter getRecruiterById(Long id){
        return recruiterRepository.findById(id).orElse(null);
    }

    /*public Recruiter getRecruiterByName(String name){
        return recruiterRepository.findByRec_name(name);
    }*/

    public String deleteRecruiter(Long id){
        recruiterRepository.deleteById(id);
        return null;
    }

    public Recruiter updateRecruiter(Recruiter recruiter){
        if (recruiter.getRec_id() == null) {
            throw new IllegalArgumentException("Recruiter id cannot be null for update.");
        }

        // Fetch the existing recruiter from the database
        Recruiter existingRecruiter = recruiterRepository.findById(recruiter.getRec_id()).orElse(null);

        // Check if the recruiter with the given id exists
        if (existingRecruiter == null) {
            throw new NoSuchElementException("Recruiter with id " + recruiter.getRec_id() + " not found.");
        }

        // Update the existing recruiter with the new values
        existingRecruiter.setRec_name(recruiter.getRec_name());
        existingRecruiter.setRec_email(recruiter.getRec_email());
        existingRecruiter.setRec_phone_num(recruiter.getRec_phone_num());
        // Save the updated recruiter to the database
        return recruiterRepository.save(existingRecruiter);
    }

    public List<String> getRecruiterColumns() {
        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'recruiter' ORDER BY ORDINAL_POSITION";
        return jdbcTemplate.query(query, new RecruiterService.ColumnNameMapper());

    }

    private static class ColumnNameMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return resultSet.getString("column_name");
        }
    }



}
