package com.zep.JobApplication.jobs;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobsServiceImpl implements  JobsService {
    private List<Jobs> jobs=new ArrayList<>();
    @Override
    public List<Jobs> findAll() {
        return jobs;
    }

    @Override
    public void createJobs(Jobs job) {
  jobs.add(job);
    }
}
