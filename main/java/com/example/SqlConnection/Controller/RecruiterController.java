package com.example.SqlConnection.Controller;

import com.example.SqlConnection.Entity.Recruiter;
import com.example.SqlConnection.Service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    @PostMapping
    public Recruiter addRecruiter(@RequestBody Recruiter recruiter){
        return recruiterService.addRecruiter(recruiter);
    }

    @GetMapping
    public List<Recruiter> getRecruiter(){
        return recruiterService.getRecruiter();
    }

    @GetMapping("/ById/{id}")
    public Recruiter getRecruiterById(@PathVariable Long id){
        return recruiterService.getRecruiterById(id);
    }

    /*@GetMapping("/ByName/{name}")
    public Recruiter getRecruiterByName(@PathVariable String name){
        return recruiterService.getRecruiterByName(name);
    }*/

    @GetMapping("/columns")
    public List<String> getCandidateColumns() {
        return recruiterService.getRecruiterColumns();
    }


    @PutMapping("/update")
    public Recruiter updateRecruiter(@RequestBody Recruiter recruiter){
        return recruiterService.updateRecruiter(recruiter);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteRecruiter(@PathVariable Long id){
        return recruiterService.deleteRecruiter(id);
    }

}
