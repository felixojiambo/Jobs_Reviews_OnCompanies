package com.zep.JobApplication.reviews.impl;

import com.zep.JobApplication.companies.Company;
import com.zep.JobApplication.companies.CompanyService;
import com.zep.JobApplication.reviews.Reviews;
import com.zep.JobApplication.reviews.ReviewsRepository;
import com.zep.JobApplication.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {
    private final ReviewsRepository reviewsRepository;
    private final CompanyService companyService;

    public ReviewsServiceImpl(ReviewsRepository reviewsRepository, CompanyService companyService) {
        this.reviewsRepository = reviewsRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Reviews> getAllReviews(Long companyId) {
        List<Reviews> reviews=reviewsRepository.findByCompanyId(companyId);
return  reviews;
    }

    @Override
    public boolean addReviews(Long companyid, Reviews reviews) {
        Company company=companyService.getCompany(companyid);
        if(company!=null){
            reviews.setCompany(company);
            reviewsRepository.save(reviews);
            return true;

        }else{return  false;}
    }

    @Override
    public Reviews getReview(Long comapnyId, Long reviewId) {
       List<Reviews> reviews= reviewsRepository.findByCompanyId(comapnyId);
        return reviews.stream().filter(review->review.getId().equals(reviewId))
                .findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Reviews updatedReview) {
        if(companyService.getCompany(companyId)!=null){
          updatedReview.setCompany(companyService.getCompanyById(companyId));
          updatedReview.setId(reviewId);
          reviewsRepository.save(updatedReview);
          return true;
        }else{return false;}
    }
}
