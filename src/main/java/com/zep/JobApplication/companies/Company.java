package com.zep.JobApplication.companies;

import com.zep.JobApplication.jobs.Jobs;
import com.zep.JobApplication.reviews.Reviews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;
    private  String description;
    @OneToMany(mappedBy = "company")
    private List<Jobs> jobs;
    @OneToMany(mappedBy = "company")
    private List<Reviews>reviews;
}
