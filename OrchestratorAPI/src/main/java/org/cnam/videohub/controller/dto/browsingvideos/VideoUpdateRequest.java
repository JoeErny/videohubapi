package org.cnam.videohub.controller.dto.browsingvideos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoUpdateRequest {

    public long id;
    public String title;
    public String link;
    public Long category_id;
    public Double price;

    @JsonCreator
    public VideoUpdateRequest(@JsonProperty("id") Long id, @JsonProperty("title") String title, @JsonProperty("link") String link, @JsonProperty("category_id") Long category_id, @JsonProperty("price") Double price) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.category_id =category_id;
        this.price = price;
    }
}
