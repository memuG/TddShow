package com.przemo.tddshow;

public class SummaryTransformer {
    private static CustomService customService;

    public SummaryTransformer(CustomService cs) {
         customService = cs;
    }

    public String callCustomServiceMethod(int a) {
        return "called customService and got: " + customService.externalResourceQuery(a);
    }

    public String transform(String order) throws IllegalArgumentException {
        if (order == null)
            throw new IllegalArgumentException("Invalid order value: null");
        return "ResultString";
    }

    public int argumentCaptorUseCase(int a) {
        Integer argument = Integer.valueOf(a *2);
        System.out.println("Integer argument: " + a);
        return a;
    }
}
