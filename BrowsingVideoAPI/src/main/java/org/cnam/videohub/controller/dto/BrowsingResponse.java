package org.cnam.videohub.controller.dto;

import org.cnam.videohub.domain.entity.Video;

import java.util.List;

public class BrowsingResponse {

public List<Video> videos_found;

    public BrowsingResponse(List<Video> videos) {
        this.videos_found = videos;
    }

}
