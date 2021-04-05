package org.cnam.videohub.controller.dto.external_api_module;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FidelityPointsAssignmentRequest {

    public Double amount;
    public Long userId;


    public FidelityPointsAssignmentRequest() {
    }

    @JsonCreator
    public FidelityPointsAssignmentRequest(@JsonProperty("user_id") Long userId, @JsonProperty("amount") Double amount) {
        this.amount = amount;
        this.userId = userId;
    }
}
