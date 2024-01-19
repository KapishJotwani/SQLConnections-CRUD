package com.example.SqlConnection.Controller;
import com.example.SqlConnection.Entity.Candidate;
import com.example.SqlConnection.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/candidates")
public class CandidateController {


    @Autowired
    private CandidateService candidateService;

    @PostMapping
    public Candidate addCandidate(@RequestBody Candidate candidate){
        return candidateService.addCandidate(candidate);
    }

    @GetMapping
    public List<Candidate> getCandidate(){
        return candidateService.getCandidate();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/ById/{id}")
    public Candidate getCandidateById(@PathVariable Long id){
        return candidateService.getCandidateById(id);
    }

    @GetMapping("/ByName/{name}")
    public Candidate getCandidateByName(@PathVariable String name){
        return candidateService.getCandidateByName(name);
    }

    @GetMapping("/columns")
    public List<String> getCandidateColumns() {
        return candidateService.getCandidateColumns();
    }


    @PutMapping("/update")
    public Candidate updateCandidate(@RequestBody Candidate candidate){
        return candidateService.updateCandidate(candidate);
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteCandidate(@PathVariable Long id){
        return candidateService.deleteCandidate(id);
    }

}