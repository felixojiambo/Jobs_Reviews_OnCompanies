package com.zep.JobApplication.jobs;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobsServiceImpl implements  JobsService {
    private List<Jobs> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Jobs> findAll() {
        return jobs;
    }

    @Override
    public void createJobs(Jobs job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Jobs getJobsByID(Long id) {
        for (Jobs job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }

        } return null;
    }
}


