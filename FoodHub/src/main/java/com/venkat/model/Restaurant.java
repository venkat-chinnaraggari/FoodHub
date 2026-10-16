package com.venkat.model;

import java.math.BigDecimal;

public class Restaurant {

    private int restaurantId;
    private String name;
    private String cuisineType;
    private int deliveryTime;
    private String address;
    private int adminUserId;
    private BigDecimal rating;
    private boolean isActive;
    private String imagePath;

    public Restaurant() {
    }

    public Restaurant(int restaurantId, String name, String cuisineType, int deliveryTime,
                       String address, int adminUserId, BigDecimal rating, boolean isActive, String ImagePath) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.cuisineType = cuisineType;
        this.deliveryTime = deliveryTime;
        this.address = address;
        this.adminUserId = adminUserId;
        this.rating = rating;
        this.isActive = isActive;
        this.imagePath = ImagePath;
    }

    public int getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }
    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }
    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public int getAdminUserId() {
        return adminUserId;
    }
    public void setAdminUserId(int adminUserId) {
        this.adminUserId = adminUserId;
    }

    public BigDecimal getRating() {
        return rating;
    }
    public void setRating(BigDecimal rating) {
        this.rating = rating;
        
    }

    public boolean getisActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String ImagePath) {
        this.imagePath = ImagePath;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantId=" + restaurantId +
                ", name='" + name + '\'' +
                ", cuisineType='" + cuisineType + '\'' +
                ", deliveryTime=" + deliveryTime +
                ", address='" + address + '\'' +
                ", adminUserId=" + adminUserId +
                ", rating=" + rating +
                ", isActive=" + isActive +
                ", ImagePath=" + imagePath +
                '}';
    }
}
