package org.cnam.videohub.controller.dto.orderpurchase;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class MakeOrderRequest {
    public Long user_id;
    public Long video_id;

    @JsonCreator
    public MakeOrderRequest( @JsonProperty("user_id") Long user_id, @JsonProperty("video_id") Long video_id) {
        this.user_id = user_id;
        this.video_id= video_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Long video_id) {
        this.video_id = video_id;
    }
}
