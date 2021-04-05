package org.cnam.videohub.domain.service;
import org.cnam.videohub.domain.entity.Video;
import org.cnam.videohub.domain.service.CategoryService;
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
public class BrowsingService {

    @Autowired
    CategoryService categoryService;

    @Autowired
    private VideoRepository videoRepository;

    public List<Video> findAllVideosByCategoryId(Long categoryId) {
        List<Video> videosFound = new ArrayList<Video>();
        List<VideoModel> videosModelsFound = new ArrayList<VideoModel>();
        videosModelsFound = videoRepository.findAllByCategory(new CategoryModel(categoryId));
        for (VideoModel videoModel : videosModelsFound
             ) {
            videosFound.add(new Video(videoModel.getId(), videoModel.getTitle(), videoModel.getLink(),videoModel.getCategory().getId(), videoModel.getPrice()));
        }
        return videosFound;
    }

}
