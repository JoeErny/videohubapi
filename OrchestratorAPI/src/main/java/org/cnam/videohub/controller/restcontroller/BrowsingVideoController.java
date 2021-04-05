package org.cnam.videohub.controller.restcontroller;

import org.cnam.videohub.controller.dto.browsingvideos.BrowsingResponse;
import org.cnam.videohub.controller.dto.browsingvideos.Video;
import org.cnam.videohub.domain.service.BrowsingVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/browse")
public class BrowsingVideoController {

    @Autowired
    BrowsingVideoService browsingVideoService;

    @GetMapping("/by_category/{category_id}")
    @ResponseBody
    public ResponseEntity<BrowsingResponse> browseVideosByCategoryId(@PathVariable("category_id") long categoryId) {
        BrowsingResponse browsingResponse = browsingVideoService.findAllVideosByCategoryId(categoryId);
        return new ResponseEntity<>(browsingResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<BrowsingResponse> getAllVideos() {
        BrowsingResponse browsingResponse = browsingVideoService.getAllVideos();
        return new ResponseEntity<>(browsingResponse, HttpStatus.OK);
    }

}
