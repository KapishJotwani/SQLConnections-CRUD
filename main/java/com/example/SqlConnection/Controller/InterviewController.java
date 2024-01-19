package com.example.SqlConnection.Controller;


import com.example.SqlConnection.Entity.Interview;
import com.example.SqlConnection.Service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @PostMapping
    public Interview addInterview(@RequestBody Interview interview){
        return interviewService.addInterview(interview);
    }

    @GetMapping
    public List<Interview> getInterview(){
        return interviewService.getInterview();
    }

    @GetMapping("/ById/{id}")
    public Interview getInterviewById(@PathVariable Long id){
        return interviewService.getInterviewById(id);
    }

    /*@GetMapping("/ByName/{name}")
    public Interview getInterviewByName(@PathVariable String name){
        return interviewService.getInterviewByName(name);
    }*/


    @GetMapping("/columns")
    public List<String> getCandidateColumns() {
        return interviewService.getInterviewColumns();
    }




    @PutMapping("/update")
    public Interview updateInterview(@RequestBody Interview interview){
        return interviewService.updateInterview(interview);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteInterview(@PathVariable Long id){
        return interviewService.deleteInterview(id);
    }



}
