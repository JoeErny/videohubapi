package org.cnam.videohub.controller.dto.orderpurchase;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentRequest {

    Long orderId;
    Double amount;

    @JsonCreator
    public PaymentRequest(@JsonProperty("order_id")  Long orderId, @JsonProperty("amount")  Double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
