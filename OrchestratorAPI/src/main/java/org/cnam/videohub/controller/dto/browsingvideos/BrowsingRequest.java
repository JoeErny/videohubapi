package org.cnam.videohub.controller.dto.browsingvideos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BrowsingRequest {

    public Long categoryId;

    @JsonCreator
    public BrowsingRequest(@JsonProperty("category_id") Long category_id) {
        this.categoryId = category_id;
    }

    public BrowsingRequest() {
    }
}
