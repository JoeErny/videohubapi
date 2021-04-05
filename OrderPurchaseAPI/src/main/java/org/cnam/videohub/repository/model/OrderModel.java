package org.cnam.videohub.repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order_table")
public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "creation_date")
    private Date date;

    @Column(name = "price")
    private Double price;

    @JoinColumn(name = "user_id", nullable = true)
    private long userId;

    @JoinColumn(name = "video_id", nullable = true)
    private long videoId;

    @Column(name="status")
    private String status;


    public OrderModel(Long id) {
        this.id = id;
    }

    public OrderModel() {
    }

    public OrderModel(Long id, Date date, Double price, long userId, long videoId, String status) {
        this.id = id;
        this.date = date;
        this.price = price;
        this.userId = userId;
        this.videoId = videoId;
        this.status = status;
    }

    public OrderModel(Date date, Double price, long userId, long videoId, String status) {
        this.date = date;
        this.price = price;
        this.userId = userId;
        this.videoId = videoId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getVideoId() {
        return videoId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }
}
