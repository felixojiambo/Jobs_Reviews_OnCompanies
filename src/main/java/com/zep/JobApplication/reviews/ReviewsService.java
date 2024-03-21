package com.zep.JobApplication.reviews;

import java.util.List;

public interface ReviewsService {
    List<Reviews> getAllReviews(Long companyId);
    void addReviews(Long companyid, Reviews reviews);
}
