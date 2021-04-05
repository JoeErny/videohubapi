package org.cnam.videohub.controller.restcontroller;


import org.cnam.videohub.controller.dto.BrowsingResponse;
import org.cnam.videohub.domain.entity.Video;
import org.cnam.videohub.domain.service.BrowsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/browse")
public class BrowsingController {

    @Autowired
    BrowsingService browsingService;

    @GetMapping("/by_category/{category_id}")
    @ResponseBody
    public ResponseEntity<BrowsingResponse> browseVideosByCategoryId(@PathVariable("category_id") long categoryId) {
        List<Video> videosFound = browsingService.findAllVideosByCategoryId(categoryId);
        BrowsingResponse browsingResponse = new BrowsingResponse(videosFound) ;
        return new ResponseEntity<>(browsingResponse, HttpStatus.OK);
    }
}
