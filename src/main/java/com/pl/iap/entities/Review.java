package com.pl.iap.entities;


import javax.persistence.*;

@Entity
@Table(name = "Reviews")
public class Review {

    private String offerId;
    private String desc;
    private Boolean accepted;
    private Integer ourPrice;
    private String reviewId;
    private String author;

    public Review() {
    }

    public Review(String reviewId, String offerId, String desc, Integer ourPrice, String author, Boolean accepted) {
        this.reviewId = reviewId;
        this.offerId = offerId;
        this.desc = desc;
        this.ourPrice = ourPrice;
        this.author = author;
        this.accepted = accepted;
    }

    public Review(String desc, Boolean accepted, Integer ourPrice, String reviewId, String author) {
        this.desc = desc;
        this.accepted = accepted;
        this.ourPrice = ourPrice;
        this.reviewId = reviewId;
        this.author = author;
    }

    @Id
    @Column(name = "ReviewId")
    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    @Column(name = "OfferId")
    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    @Column(name = "Description")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Column(name = "Accepted")
    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    @Column(name = "OurPrice")
    public Integer getOurPrice() {
        return ourPrice;
    }

    public void setOurPrice(Integer ourPrice) {
        this.ourPrice = ourPrice;
    }

    @Column(name = "Author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
