package org.cnam.videohub.controller.dto.browsingvideos;

public class NumberViewsOfVideo {

    public Long videoId;
    public Long numberOfViews;

    public NumberViewsOfVideo(Long videoId, Long numberOfViews) {
        this.videoId = videoId;
        this.numberOfViews = numberOfViews;
    }
}
