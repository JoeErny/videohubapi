package org.cnam.videohub.domain.service;
import org.cnam.videohub.controller.dto.browsingvideos.BrowsingResponse;
import org.cnam.videohub.controller.dto.browsingvideos.Video;
import org.cnam.videohub.controller.dto.browsingvideos.VideoResponse;
import org.cnam.videohub.controller.dto.orderpurchase.OrderPurchaseRequest;
import org.cnam.videohub.controller.dto.orderpurchase.OrderPurchaseResponse;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BrowsingVideoService {

    private static final String getVideoByIdUrl = "http://localhost:8081/videohub/rest/video/{id}";
    private static final String getVideosByCategoryId = "http://localhost:8081/videohub/rest/browse/by_category/{category_id}";
    private static final String getAllVideos= "http://localhost:8081/videohub/rest/video/all/";

    public BrowsingResponse findAllVideosByCategoryId(Long categoryId) {

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(getVideosByCategoryId,  BrowsingResponse.class, categoryId);
    }

    public VideoResponse getVideoById(Long id)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(getVideoByIdUrl,  VideoResponse.class, id);
    }

    public BrowsingResponse getAllVideos() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(getAllVideos,  BrowsingResponse.class);
    }


}
