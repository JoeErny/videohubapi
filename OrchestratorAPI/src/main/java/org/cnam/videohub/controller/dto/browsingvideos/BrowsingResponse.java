package org.cnam.videohub.controller.dto.browsingvideos;

import java.util.List;

public class BrowsingResponse {

public List<Video> videos_found;

    public BrowsingResponse(List<Video> videos) {
        this.videos_found = videos;
    }

    public BrowsingResponse() {
    }
}
