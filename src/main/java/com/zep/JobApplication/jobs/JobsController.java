package com.zep.JobApplication.jobs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/crud")//At class level, request mapping sets a base url
public class JobsController {
    private JobsService jobsService;

    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Jobs>> findAll() {
        return ResponseEntity.ok(jobsService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJobs(@RequestBody Jobs job) {
        jobsService.createJobs(job);
        return  new ResponseEntity<>("Job added successfully",HttpStatus.OK);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Jobs> getJobsByID(@PathVariable Long id) {

        Jobs job = jobsService.getJobsByID(id);
        if (job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/jobs/{id}")
    public  ResponseEntity<String>deleteJob(@PathVariable Long id){
        boolean deleted=jobsService.deleteJobById(id);
        if(deleted)
            return  new ResponseEntity<>("Job deleted successfully",HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/jobs/{id}")
    //we can use request mapping at method levelin every request in the above instead of using specialised methods
    //@RequestMapping9(value="/jobs/{id},method=RequestMethod.PUT)
public  ResponseEntity<String>updateJob(@PathVariable Long id ,@RequestBody Jobs updatedJob){
        boolean updated=jobsService.updateJob(id,updatedJob);
        if(updated)
            return new  ResponseEntity<>("Job updated successfully",HttpStatus.OK);
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}