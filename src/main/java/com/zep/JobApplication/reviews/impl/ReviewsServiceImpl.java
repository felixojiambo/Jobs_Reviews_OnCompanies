package com.zep.JobApplication.reviews.impl;

import com.zep.JobApplication.reviews.Reviews;
import com.zep.JobApplication.reviews.ReviewsRepository;
import com.zep.JobApplication.reviews.ReviewsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {
    private ReviewsRepository reviewsRepository;
    @Override
    public List<Reviews> getAllReviews(Long companyId) {
        List<Reviews> reviews=reviewsRepository.findByCompanyId(companyId);
return  reviews;
    }
}
