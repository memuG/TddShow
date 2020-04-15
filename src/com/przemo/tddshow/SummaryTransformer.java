package com.przemo.tddshow;

public class SummaryTransformer {
    public String transform(String order) throws IllegalArgumentException {
        if (order == null)
            throw new IllegalArgumentException("Invalid order value: null");
        return "ResultString";
    }
}
