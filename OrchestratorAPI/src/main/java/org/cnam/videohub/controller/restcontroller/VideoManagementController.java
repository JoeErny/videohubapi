package org.cnam.videohub.controller.restcontroller;

import org.cnam.videohub.controller.dto.browsingvideos.VideoRequest;
import org.cnam.videohub.controller.dto.browsingvideos.VideoResponse;
import org.cnam.videohub.domain.service.VideoManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/video-management")
public class VideoManagementController {

    @Autowired
    VideoManagementService videoManagementService;

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<VideoResponse> createVideo(@RequestBody VideoRequest videoToCreate) {

        return new ResponseEntity<>(videoManagementService.upload(videoToCreate), HttpStatus.OK);

    }


}
