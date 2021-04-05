package org.cnam.videohub.domain.entity;

import java.util.Date;

public class Viewing {
    public Long id;
    public Long userId;
    public Long videoId;
    public Date date;

    public Viewing(Long id, Long userId, Long videoId, Date date) {
        this.id = id;
        this.userId = userId;
        this.videoId = videoId;
        this.date = date;
    }
}
