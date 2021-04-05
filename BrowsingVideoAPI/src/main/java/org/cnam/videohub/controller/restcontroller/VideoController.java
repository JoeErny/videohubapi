
package org.cnam.videohub.controller.restcontroller;

import org.cnam.videohub.controller.dto.BrowsingResponse;
import org.cnam.videohub.controller.dto.VideoRequest;
import org.cnam.videohub.controller.dto.VideoResponse;
import org.cnam.videohub.controller.dto.VideoUpdateRequest;
import org.cnam.videohub.domain.entity.Video;
import org.cnam.videohub.domain.entity.VideoToCreate;
import org.cnam.videohub.domain.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<VideoResponse> getVideo(@PathVariable("id") long id) {
        Video videoFound = videoService.getById(id);

        VideoResponse videoResponse = new VideoResponse(videoFound.id, videoFound.title, videoFound.link, videoFound.category_id, videoFound.price);

        return new ResponseEntity<>(videoResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<VideoResponse> createVideo(@RequestBody VideoRequest videoToRequest) {
        VideoToCreate videoToCreate = new VideoToCreate(videoToRequest.title, videoToRequest.link, videoToRequest.category_id, videoToRequest.price);

        Video videoCreated = videoService.create(videoToCreate);

        VideoResponse videoResponse = new VideoResponse(videoCreated.id, videoCreated.title, videoCreated.link, videoCreated.category_id, videoCreated.price);

        return new ResponseEntity<>(videoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteVideo(@PathVariable("id") long id) {
       videoService.deleteById(id);
    }


    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<VideoResponse> updateVideo(@RequestBody VideoUpdateRequest videoToRequestUpdate) {
        Video videoToUpdate = new Video(videoToRequestUpdate.id,videoToRequestUpdate.title, videoToRequestUpdate.link, videoToRequestUpdate.category_id, videoToRequestUpdate.price);
        Video videoUpdated = videoService.update(videoToUpdate);
        VideoResponse videoResponse = new VideoResponse(videoUpdated.id, videoUpdated.title, videoUpdated.link, videoUpdated.category_id, videoUpdated.price);

        return new ResponseEntity<>(videoResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<BrowsingResponse> getAll() {
        List<Video> videosFound = videoService.getAll();
        BrowsingResponse browsingResponse = new BrowsingResponse(videosFound) ;
        return new ResponseEntity<>(browsingResponse, HttpStatus.OK);
    }

}
