package com.zep.JobApplication.reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getAllReviews(Long companyId);
    boolean addReviews(Long companyid, Reviews reviews);
    Reviews getReview(Long comapnyId, Long reviewId);
    boolean updateReview(Long companyId,Long reviewId, Reviews reviews);

    boolean deleteReview(Long companyId, Long reviewId);
}
