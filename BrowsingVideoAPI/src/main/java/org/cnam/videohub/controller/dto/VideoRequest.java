package org.cnam.videohub.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoRequest {

    public String title;
    public String link;
    public Long category_id;
    public Double price;

    //test commentaire

    @JsonCreator
    public VideoRequest(@JsonProperty("title") String title,@JsonProperty("link") String link, @JsonProperty("category_id") Long category_id, @JsonProperty("price") Double price) {
        this.title = title;
        this.link = link;
        this.category_id =category_id;
        this.price = price;
    }

}

