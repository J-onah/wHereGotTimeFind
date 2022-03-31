package com.example.wheregottimefind.data;

import com.example.wheregottimefind.pojo.FullReview;
import com.example.wheregottimefind.pojo.Review;
import com.example.wheregottimefind.pojo.Vendor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FullReviewData {
    ArrayList<FullReview> full_reviews;
    static FullReviewData instance;

    private FullReviewData() {
        full_reviews = new ArrayList<>();
    }

    public static FullReviewData getInstance() {
        if (instance == null) {
            instance = new FullReviewData();
        }
        return instance;
    }

    public void addFullReview(FullReview full_review) {
        full_reviews.add(full_review);
    }

    public ArrayList<FullReview> getAllReviews() {
        return full_reviews;
    }

    public void clearAll() {
        full_reviews = new ArrayList<>();
    }

    public List<Vendor> getVendorsFromData() {
        Set<Vendor> vendors = new HashSet<>();
        for (FullReview full_review: full_reviews) {
            vendors.add(full_review.getVendor());
        }
        List<Vendor> res = new ArrayList<>(vendors);
        return res;
    }

//    public List<Review> getReviewsByVendor() {
//        System.out.println("hi");
//    }
}
