package com.zep.JobApplication.jobs;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobsServiceImpl implements  JobsService {
  private  JobsRepository jobsRepository;
    private Long nextId = 1L;

    public JobsServiceImpl(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    @Override
    public List<Jobs> findAll() {
        return jobsRepository.findAll();
    }

    @Override
    public void createJobs(Jobs job) {
        job.setId(nextId++);
        jobsRepository.save(job);
    }

    @Override
    public Jobs getJobsByID(Long id) {
       return jobsRepository.findById(id).orElse(null);
    }
    @Override
    public boolean deleteJobById(Long id){
        try {
            jobsRepository.deleteById(id);
            return true;
        }catch (Exception e){ return  false;}

    }

    @Override
    public boolean updateJob(Long id, Jobs updatedJob) {
        Optional<Jobs>jobsOptional=jobsRepository.findById(id);
        {
            if (jobsOptional.isPresent()) {
                Jobs job = jobsOptional.get();
                {
                    job.setTitle(updatedJob.getTitle());
                    job.setDescription(updatedJob.getDescription());
                    job.setMinSalary(updatedJob.getMinSalary());

                    job.setMaxSalary(updatedJob.getMaxSalary());
                    job.setLocation(updatedJob.getLocation());
                    jobsRepository.save(job);
                    return true;
                }
            }
            return false;
        }}
}


