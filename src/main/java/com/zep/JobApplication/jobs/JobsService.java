package com.zep.JobApplication.jobs;

import java.util.ArrayList;
import java.util.List;

public interface JobsService {

    List<Jobs> findAll();
    void createJobs(Jobs job);
}
