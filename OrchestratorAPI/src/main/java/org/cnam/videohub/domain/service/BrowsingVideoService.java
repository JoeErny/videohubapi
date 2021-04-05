package org.cnam.videohub.domain.service;
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

    public List<Video> findAllVideosByCategoryId(Long categoryId) {
        List<Video> videosFound = new ArrayList<Video>();
        return videosFound;
    }

    public VideoResponse getVideoById(Long id)
    {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(getVideoByIdUrl,  VideoResponse.class, id);
    }



}
