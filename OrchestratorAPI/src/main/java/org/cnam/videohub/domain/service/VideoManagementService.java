package org.cnam.videohub.domain.service;


import org.cnam.videohub.controller.dto.browsingvideos.Video;
import org.cnam.videohub.controller.dto.browsingvideos.VideoRequest;
import org.cnam.videohub.controller.dto.browsingvideos.VideoResponse;
import org.cnam.videohub.controller.dto.orderpurchase.MakeOrderRequest;
import org.cnam.videohub.controller.dto.orderpurchase.OrderRequest;
import org.cnam.videohub.controller.dto.orderpurchase.OrderResponse;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class VideoManagementService {
    private static final String uploadNewVideoUrl = "http://localhost:8081/videohub/rest/video/create";

    public VideoResponse upload(VideoRequest videoToCreate) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<VideoRequest> videoUploadHttp = new HttpEntity<>(videoToCreate);
        return restTemplate.postForObject(uploadNewVideoUrl, videoUploadHttp, VideoResponse.class);
    }

}
