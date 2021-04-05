package org.cnam.videohub.controller.dto.orderpurchase;

public class ContinueToPurchaseResponse {


    String orderStatus;
    OrderResponse orderCreated;
    String urlContinueToPurchase;
    OrderPurchaseRequest jsonToPostContinueToPurchase;


    public ContinueToPurchaseResponse(String orderStatus, OrderResponse orderCreated, String urlContinueToPurchase, OrderPurchaseRequest jsonToPostContinueToPurchase) {
        this.orderStatus = orderStatus;
        this.orderCreated = orderCreated;
        this.urlContinueToPurchase = urlContinueToPurchase;
        this.jsonToPostContinueToPurchase = jsonToPostContinueToPurchase;
    }

    public ContinueToPurchaseResponse() {
    }
}
