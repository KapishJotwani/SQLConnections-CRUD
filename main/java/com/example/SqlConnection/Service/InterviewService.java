package com.example.SqlConnection.Service;

import com.example.SqlConnection.Entity.Interview;

import com.example.SqlConnection.Repository.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.jdbc.core.RowMapper;

@Service
public class InterviewService {

    private final JdbcTemplate jdbcTemplate;

    public InterviewService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Autowired
    private InterviewRepository interviewRepository;

    public Interview addInterview(Interview interview){
        return interviewRepository.save(interview);
    }

    public List<Interview> addInterview(List<Interview> interview){
        return interviewRepository.saveAll(interview);
    }

    public List<Interview> getInterview(){
        return interviewRepository.findAll();
    }

    public Interview getInterviewById(Long id){
        return interviewRepository.findById(id).orElse(null);
    }

    /*public Interview getInterviewByName(String name){
        return interviewRepository.findByName(name);
    }*/

    public String deleteInterview(Long id){
        interviewRepository.deleteById(id);
        return null;
    }

    public Interview updateInterview(Interview interview){
        if (interview.getInt_id() == null) {
            throw new IllegalArgumentException("Interview id cannot be null for update.");
        }

        // Fetch the existing interview from the database
        Interview existingInterview = interviewRepository.findById(interview.getInt_id()).orElse(null);

        // Check if the interview with the given id exists
        if (existingInterview == null) {
            throw new NoSuchElementException("Interview with id " + interview.getInt_date() + " not found.");
        }

        // Update the existing interview with the new values
        existingInterview.setInt_date(interview.getInt_date());
        existingInterview.setInt_mode(interview.getInt_mode());
        existingInterview.setInt_result(interview.getInt_result());


        // Save the updated interview to the database
        return interviewRepository.save(existingInterview);
    }

    public List<String> getInterviewColumns() {
        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'interview' ORDER BY ORDINAL_POSITION";
        return jdbcTemplate.query(query, new InterviewService.ColumnNameMapper());

    }

    private static class ColumnNameMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return resultSet.getString("column_name");
        }
    }





}
