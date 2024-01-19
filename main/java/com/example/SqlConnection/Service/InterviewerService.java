package com.example.SqlConnection.Service;

import com.example.SqlConnection.Entity.Interviewer;
import com.example.SqlConnection.Repository.InterviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.jdbc.core.RowMapper;

@Service
public class InterviewerService {

    private final JdbcTemplate jdbcTemplate;

    public InterviewerService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Autowired
    private InterviewerRepository interviewerRepository;


    public Interviewer addInterviewer(Interviewer interviewer){
        return interviewerRepository.save(interviewer);
    }

    public List<Interviewer> addInterviewer(List<Interviewer> interviewer){
        return interviewerRepository.saveAll(interviewer);
    }

    public List<Interviewer> getInterviewer(){
        return interviewerRepository.findAll();
    }

    public Interviewer getInterviewerById(Long id){
        return interviewerRepository.findById(id).orElse(null);
    }

    /*public Interviewer getInterviewerByName(String i_name){
        return interviewerRepository.findByName(i_name);
    }*/

    public String deleteInterviewer(Long id){
        interviewerRepository.deleteById(id);
        return null;
    }

    public Interviewer updateInterviewer(Interviewer interviewer){
        if (interviewer.getI_id() == null) {
            throw new IllegalArgumentException("Interviewer id cannot be null for update.");
        }

        // Fetch the existing interviewer from the database
        Interviewer existingInterviewer = interviewerRepository.findById(interviewer.getI_id()).orElse(null);

        // Check if the interviewer with the given id exists
        if (existingInterviewer == null) {
            throw new NoSuchElementException("Interviewer with id " + interviewer.getI_id() + " not found.");
        }

        // Update the existing interviewer with the new values
        existingInterviewer.setI_name(interviewer.getI_name());
        existingInterviewer.setI_email(interviewer.getI_email());
        existingInterviewer.setI_designation(interviewer.getI_designation());
        existingInterviewer.setI_phone_num(interviewer.getI_phone_num());

        // Save the updated interviewer to the database
        return interviewerRepository.save(existingInterviewer);
    }

    public List<String> getInterviewerColumns() {
        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'interviewer' ORDER BY ORDINAL_POSITION";
        return jdbcTemplate.query(query, new InterviewerService.ColumnNameMapper());

    }

    private static class ColumnNameMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return resultSet.getString("column_name");
        }
    }




}
