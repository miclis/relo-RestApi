package com.pl.iap.controllers;


import com.pl.iap.entities.Review;
import com.pl.iap.exceptions.ResourceNotFoundException;
import com.pl.iap.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localOffice")
@CrossOrigin(origins = "http://localhost:8081")
public class ReviewController {

    @Autowired
    ReviewRepository reviewRepository;

    @PostMapping("/review")
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        review.setReviewId("00009");
        final Review addedReview = reviewRepository.save(review);
        return ResponseEntity.ok().body(addedReview);

    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getReviewByOfferId(@RequestParam String offerId)
           throws ResourceNotFoundException {
        List<Review> reviews = reviewRepository.findReviewsByOfferId(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("There are no reviews for offer with id: " + offerId));

        return ResponseEntity.ok().body(reviews);
    }

    @RequestMapping("/review/all")
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
