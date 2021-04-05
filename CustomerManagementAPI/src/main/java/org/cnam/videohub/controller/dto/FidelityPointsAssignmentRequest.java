package org.cnam.videohub.controller.dto;

public class FidelityPointsAssignmentRequest {

    public Long userId;
    public Double amount;

    public FidelityPointsAssignmentRequest( Long userId, Double amount) {
        this.userId = userId;
        this.amount = amount;
    }
    public FidelityPointsAssignmentRequest() {
    }

}
