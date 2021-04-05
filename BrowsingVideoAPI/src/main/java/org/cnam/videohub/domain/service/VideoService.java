package org.cnam.videohub.domain.service;

import org.cnam.videohub.domain.entity.Video;
import org.cnam.videohub.domain.entity.VideoToCreate;
import org.cnam.videohub.repository.VideoRepository;
import org.cnam.videohub.repository.model.CategoryModel;
import org.cnam.videohub.repository.model.VideoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public Video getById(Long id) {
        VideoModel entityVideoFound = videoRepository.getOne(id);

        return new Video(entityVideoFound.getId(), entityVideoFound.getTitle(), entityVideoFound.getLink(), entityVideoFound.getCategory().getId(), entityVideoFound.getPrice());
    }

    public Video create(VideoToCreate videoToCreate) {
        VideoModel entityVideoToCreate = new VideoModel(videoToCreate.title, videoToCreate.link, new CategoryModel(videoToCreate.category_id), videoToCreate.price);
        VideoModel entityVideoCreated = videoRepository.save(entityVideoToCreate);
        return new Video(entityVideoCreated.getId(), entityVideoCreated.getTitle(), entityVideoCreated.getLink(), entityVideoCreated.getCategory().getId(), entityVideoCreated.getPrice());
    }

    public void deleteById(long id) {
        try {
            videoRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Video update(Video videoToUpdate) {
        VideoModel entityVideoToUpdate = new VideoModel(videoToUpdate.id, videoToUpdate.title, videoToUpdate.link, new CategoryModel(videoToUpdate.category_id), videoToUpdate.price);
        VideoModel entityVideoUpdated = videoRepository.save(entityVideoToUpdate);
        return new Video(entityVideoUpdated.getId(), entityVideoUpdated.getTitle(), entityVideoUpdated.getLink(), entityVideoUpdated.getCategory().getId(), entityVideoUpdated.getPrice());
    }

    public List<Video> getAll()
    {
        List<Video> videosFound = new ArrayList<>();
        List<VideoModel> videosModelsFound = videoRepository.findAll();
        for (VideoModel videoModel: videosModelsFound
             ) {
            videosFound.add(new Video(videoModel.getId(), videoModel.getTitle(), videoModel.getLink(), videoModel.getCategory().getId(), videoModel.getPrice()));
        }
        return videosFound;
    }




}
