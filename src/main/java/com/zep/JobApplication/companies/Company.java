package com.zep.JobApplication.companies;

import com.zep.JobApplication.jobs.Jobs;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Company {
    private  Long id;
    private  String name;
    private  String description;
    @OneToMany
    private List<Jobs> jobs;

    //private List<Reviews>reviews
}
