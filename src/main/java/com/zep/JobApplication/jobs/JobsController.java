package com.zep.JobApplication.jobs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class JobsController {
 private  JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @GetMapping("/jobs")
    public List<Jobs> findAll(){
        return jobsService.findAll();
    }
    @PostMapping("/jobs")
    public  String createJobs(@RequestBody Jobs  job){
       jobsService.createJobs(job);
       return  "Jobs added succesfully";
    }
}
