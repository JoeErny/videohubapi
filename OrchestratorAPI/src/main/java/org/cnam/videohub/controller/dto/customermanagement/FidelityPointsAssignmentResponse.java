package org.cnam.videohub.controller.dto.customermanagement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FidelityPointsAssignmentResponse {

    public Integer pointsAdded;
    public Integer totalUserPoints;

    @JsonCreator
    public FidelityPointsAssignmentResponse(@JsonProperty("points_added") Integer pointsAdded,@JsonProperty("total_user_points") Integer totalUserPoints) {
        this.pointsAdded = pointsAdded;
        this.totalUserPoints = totalUserPoints;
    }

    public FidelityPointsAssignmentResponse() {
    }
}
