package com.pl.iap.repositories;

import com.pl.iap.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, String> {

    Optional<List<Review>> findReviewsByOfferId(String offerId);
}
