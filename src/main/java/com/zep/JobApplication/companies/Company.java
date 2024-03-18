package com.zep.JobApplication.companies;

import com.zep.JobApplication.jobs.Jobs;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private  String description;
    @OneToMany(mappedBy = "company")
    private List<Jobs> jobs;

    //private List<Reviews>reviews
}
