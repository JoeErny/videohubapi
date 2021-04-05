package org.cnam.videohub.repository.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "video")
public class VideoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = true)
    private CategoryModel category;

    public VideoModel(String title, String link, CategoryModel category,Double price ) {
        this.title = title;
        this.link = link;
        this.category = category;
        this.price = price;
    }

    public VideoModel(Long id, String title, String link, CategoryModel category,Double price) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.category = category;
        this.price = price;
    }

    public VideoModel(Long id) {
        this.id = id;
    }

    public VideoModel(Long id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }

    public VideoModel(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public VideoModel() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }



}
