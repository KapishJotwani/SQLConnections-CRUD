package com.example.SqlConnection.Controller;

import com.example.SqlConnection.Entity.Interviewer;
import com.example.SqlConnection.Service.InterviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/interviewer")
public class InterviewerController {
    
    @Autowired
    private InterviewerService interviewerService;

    @PostMapping
    public Interviewer addInterviewer(@RequestBody Interviewer interviewer){
        return interviewerService.addInterviewer(interviewer);
    }

    @GetMapping
    public List<Interviewer> getInterviewer(){
        return interviewerService.getInterviewer();
    }

    @GetMapping("/ById/{id}")
    public Interviewer getInterviewerById(@PathVariable Long id){
        return interviewerService.getInterviewerById(id);
    }

    /*@GetMapping("/ByName/{name}")
    public Interviewer getInterviewerByName(@PathVariable String name){
        return interviewerService.getInterviewerByName(name);
    }*/


    @GetMapping("/columns")
    public List<String> getCandidateColumns() {
        return interviewerService.getInterviewerColumns();
    }

    @PutMapping("/update")
    public Interviewer updateInterviewer(@RequestBody Interviewer interviewer){
        return interviewerService.updateInterviewer(interviewer);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteInterviewer(@PathVariable Long id){
        return interviewerService.deleteInterviewer(id);
    }

}
