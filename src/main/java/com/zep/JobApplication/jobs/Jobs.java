package com.zep.JobApplication.jobs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Jobs {
    private  Long Id;
    private  String title;
    private  String description;
    private String minSalary;
    private  String maxSalary;
    private  String Location;

}
