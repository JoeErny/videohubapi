package org.cnam.videohub.controller.dto.browsingvideos;

public class Video {
    public Long id;
    public String title;
    public String link;
    public Long category_id;
    public Double price;

    public Video(Long id, String title, String link, Long category_id, Double price) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.category_id=category_id;
        this.price = price;
    }

    public Video() {
    }
}
