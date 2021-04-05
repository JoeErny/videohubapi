package org.cnam.videohub.domain.entity;

import java.util.Date;

public class ViewingToCreate {
    public Long userId;
    public Long videoId;
    public Date date;

    public ViewingToCreate(Long userId, Long videoId, Date date) {
        this.userId = userId;
        this.videoId = videoId;
        this.date = date;
    }
}
