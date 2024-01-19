package com.example.SqlConnection.Service;

import com.example.SqlConnection.Entity.Job;
import com.example.SqlConnection.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.jdbc.core.RowMapper;


@Service
public class JobService {
   
    @Autowired
    private JobRepository jobRepository;

    private final JdbcTemplate jdbcTemplate;
    public JobService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    public Job addJob(Job job){
        return jobRepository.save(job);
    }

    public List<Job> addJob(List<Job> job){
        return jobRepository.saveAll(job);
    }

    public List<Job> getJob(){
        return jobRepository.findAll();
    }

    public Job getJobById(Long id){
        return jobRepository.findById(id).orElse(null);
    }

//    public Job getJobByRole(String role){
//        return jobRepository.findByRole(role);
//    }

    public String deleteJob(Long id){
        jobRepository.deleteById(id);
        return null;
    }

    public Job updateJob(Job job){
        if (job.getJ_id() == null) {
            throw new IllegalArgumentException("Job id cannot be null for update.");
        }

        // Fetch the existing job from the database
        Job existingJob = jobRepository.findById(job.getJ_id()).orElse(null);

        // Check if the job with the given id exists
        if (existingJob == null) {
            throw new NoSuchElementException("Job with id " + job.getJ_id() + " not found.");
        }

        // Update the existing job with the new values
        existingJob.setJ_id(job.getJ_id());
        existingJob.setJ_company(job.getJ_company());
        existingJob.setJ_role(job.getJ_role());

        // Save the updated job to the database
        return jobRepository.save(existingJob);
    }

    public List<String> getJobColumns() {
        String query = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'job' ORDER BY ORDINAL_POSITION";
        return jdbcTemplate.query(query, new JobService.ColumnNameMapper());

    }

    private static class ColumnNameMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return resultSet.getString("column_name");
        }
    }
    
}
