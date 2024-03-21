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
    public void addReviews(Long companyid, Reviews reviews) {
        Company company=companyService.getCompany(companyid);
        if(company!=null){
            reviews.setCompany(company);
            reviewsRepository.save(reviews);
        }
    }
}
