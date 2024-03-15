package com.zep.JobApplication.jobs;

import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/jobs/{id}")
    public Jobs getJobsByID(@PathVariable Long id){
  Jobs job=jobsService.getJobsByID(id);
  return  job;
    }
}
