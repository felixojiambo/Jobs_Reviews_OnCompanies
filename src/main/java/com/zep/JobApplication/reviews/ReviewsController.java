package com.zep.JobApplication.reviews;

import com.zep.JobApplication.companies.Company;
import com.zep.JobApplication.companies.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company/")
public class ReviewsController {
    private  final ReviewsService reviewsService;

    public ReviewsController(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;

    }
    @GetMapping("/reviews")
    public  ResponseEntity<List<Reviews>>getAllReviews(@PathVariable Long companyid){
        return  new ResponseEntity<>(reviewsService.getAllReviews(companyid), HttpStatus.OK);
    }
    @PostMapping("/reviews/")
    public ResponseEntity<String> addReviews(@PathVariable Long companyid, @RequestBody Reviews reviews) {
      boolean isReviewSaved= reviewsService.addReviews(companyid,reviews);
      if(isReviewSaved) {

          return new ResponseEntity<>("Review Added Succesfully", HttpStatus.OK);
      } else{
              return new  ResponseEntity<>("Review not saved",HttpStatus.NOT_FOUND);
      }
    }
    @GetMapping("/reviews/{reviewsId}")
    public  ResponseEntity<Reviews>getReview(@PathVariable Long companyId, @PathVariable Long reviewsId){
     return new ResponseEntity<>(reviewsService.getReview(companyId,reviewsId), HttpStatus.OK);
    }
    @PutMapping("/reviews/{reviewsId}")
    public  ResponseEntity<String>updateReview(@PathVariable Long companyId,@PathVariable Long reviewsId, @RequestBody Reviews reviews){
 boolean isReviewUpdated=reviewsService.updateReview(companyId, reviewsId,reviews);
 if(isReviewUpdated)
        return  new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
else
     return  new ResponseEntity<>("Review not updated",HttpStatus.NOT_FOUND);
    }
}
