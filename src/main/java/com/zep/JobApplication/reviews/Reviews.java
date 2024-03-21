package com.zep.JobApplication.reviews;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zep.JobApplication.companies.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String title;
    private  String description;
    private  double rating;
    @JsonIgnore
    @ManyToOne
    private Company company;
}
