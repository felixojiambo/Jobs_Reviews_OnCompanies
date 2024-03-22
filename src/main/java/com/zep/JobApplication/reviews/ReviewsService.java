package com.zep.JobApplication.reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getAllReviews(Long companyId);
    boolean addReviews(Long companyid, Reviews reviews);
    Reviews getReview(Long comapnyId, Long reviewId);
}
