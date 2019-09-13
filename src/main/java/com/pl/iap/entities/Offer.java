package com.pl.iap.entities;

import javax.persistence.*;

@Entity
@Table(name = "Offers")
public class Offer {

    private String name;
    private String officeId;
    private String owner;
    private int ownersPrice;
    private String imageUrl;
    private String city;
    private String postalCode;
    private String street;
    private String offerId;

    @Id
    @Column(name = "OfferId")
    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "OfficeId")
    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    @Column(name = "Owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Column(name = "OwnersPrice")
    public int getOwnersPrice() {
        return ownersPrice;
    }

    public void setOwnersPrice(int ownersPrice) {
        this.ownersPrice = ownersPrice;
    }

    @Column(name = "ImageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "PostalCode")
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "Street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Offer(String offerId, String name, String officeId, String owner, int ownersPrice, String imageUrl, String city, String postalCode, String street) {
        this.name = name;
        this.officeId = officeId;
        this.owner = owner;
        this.ownersPrice = ownersPrice;
        this.imageUrl = imageUrl;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.offerId = offerId;
    }

    public Offer() {
    }
}
