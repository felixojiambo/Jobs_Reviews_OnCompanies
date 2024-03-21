package com.zep.JobApplication.reviews;

import com.zep.JobApplication.companies.Company;
import com.zep.JobApplication.companies.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/{companyid}")
public class ReviewsController {
    private  ReviewsService reviewsService;
    private CompanyService companyService;
    private ReviewsRepository reviewsRepository;
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }
    @GetMapping("/reviews")
    public  ResponseEntity<List<Reviews>>getAllReviews(@PathVariable Long companyid){
        return  new ResponseEntity<>(reviewsService.getAllReviews(companyid), HttpStatus.OK);
    }
    @PostMapping("/reviews/{companyid}")
    public ResponseEntity<Reviews> addReviews(@PathVariable Long companyid, @RequestBody Reviews reviews) {
        Company company = companyService.getCompany(companyid);
        if (company != null) {
            reviews.setCompany(company);
            Reviews savedReview = reviewsRepository.save(reviews);
            return ResponseEntity.ok(savedReview);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
