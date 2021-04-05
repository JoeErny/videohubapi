package org.cnam.videohub.domain.entity;

public class VideoToCreate {
    public String title;
    public String link;
    public Long category_id;
    public Double price;
    public VideoToCreate(String title, String link,Long category_id, Double price) {
        this.title = title;
        this.link = link;
        this.category_id=category_id;
        this.price = price;
    }
}
