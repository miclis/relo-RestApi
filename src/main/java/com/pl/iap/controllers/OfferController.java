package com.pl.iap.controllers;

import com.pl.iap.entities.Offer;
import com.pl.iap.entities.Review;
import com.pl.iap.exceptions.ResourceNotFoundException;
import com.pl.iap.repositories.OfferRepository;
import com.pl.iap.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/localOffice")
@CrossOrigin(origins = "http://localhost:8081")
public class OfferController {

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping("/offers")
    public ResponseEntity<List<Offer>> getAllOffers() {
        List<Offer> offers = offerRepository.findAll();
        return ResponseEntity.ok().body(offers);
    }

    @GetMapping("/offer")
    public ResponseEntity<Offer> getOfferById(@RequestParam String offerId)
            throws ResourceNotFoundException {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("There are no offers for office with id: " + offerId));

        return ResponseEntity.ok().body(offer);
    }

    @DeleteMapping("/offer")
    public ResponseEntity deleteOffer(@RequestParam String offerId) throws ResourceNotFoundException {
        final Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new ResourceNotFoundException("There are no offers for office with id: " + offerId));

        reviewRepository.findReviewsByOfferId(offerId).ifPresent(reviews1 -> reviews1.forEach(review -> reviewRepository.delete(review)));

        offerRepository.delete(offer);

        return ResponseEntity.ok("Offer deleted");
    }

    @PostMapping("/offer")
    public ResponseEntity addOffer(@Valid @RequestBody Offer offer) {
        offer.setOfferId("00009");
        final Offer addedOffer = offerRepository.save(offer);
        return ResponseEntity.ok().body(addedOffer);

    }

    @PutMapping("/offer")
    public ResponseEntity<Offer> editOffer(@Valid @RequestBody Offer offerDetails) throws ResourceNotFoundException {
        final Offer offer = offerRepository.findById(offerDetails.getOfferId())
                .orElseThrow(() -> new ResourceNotFoundException("There are no offers for office with id: " + offerDetails.getOfferId()));

        offer.setCity(offerDetails.getCity());
        offer.setImageUrl(offerDetails.getImageUrl());
        offer.setName(offerDetails.getName());
        offer.setOwner(offerDetails.getOwner());
        offer.setOwnersPrice(offerDetails.getOwnersPrice());
        offer.setPostalCode(offerDetails.getPostalCode());
        offer.setStreet(offerDetails.getStreet());
        offer.setOfficeId(offerDetails.getOfficeId());
        offer.setOfferId(offerDetails.getOfferId());

        final Offer updatedOffer = offerRepository.save(offer);
        return ResponseEntity.ok(updatedOffer);
    }


}
