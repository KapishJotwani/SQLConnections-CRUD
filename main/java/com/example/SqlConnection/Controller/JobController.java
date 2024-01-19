package com.example.SqlConnection.Controller;

import com.example.SqlConnection.Entity.Job;
import com.example.SqlConnection.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/job")
public class JobController {

    @Autowired
    private JobService jobService;

    @PostMapping
    public Job addJob(@RequestBody Job job){
        return jobService.addJob(job);
    }

    @GetMapping
    public List<Job> getJob(){
        return jobService.getJob();
    }

    @GetMapping("/ById/{id}")
    public Job getJobById(@PathVariable Long id){
        return jobService.getJobById(id);
    }

    /*@GetMapping("/ByRole/{role}")
    public Job getJobByRole(@PathVariable String role){
        return jobService.getJobByRole(role);
    }*/

    @GetMapping("/columns")
    public List<String> getJobColumns() {
        return jobService.getJobColumns();
    }



    @PutMapping("/update")
    public Job updateJob(@RequestBody Job job){
        return jobService.updateJob(job);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteJob(@PathVariable Long id){
        return jobService.deleteJob(id);
    }

}
