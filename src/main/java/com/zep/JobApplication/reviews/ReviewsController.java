package com.zep.JobApplication.reviews;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewsController {
    private  ReviewsService reviewsService;
    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }
    @GetMapping("/reviews")
    public  ResponseEntity<List<Reviews>>getAllReviews(@PathVariable Long id){
        return  new ResponseEntity<>(reviewsService.getAllReviews(id), HttpStatus.OK);
    }
}
