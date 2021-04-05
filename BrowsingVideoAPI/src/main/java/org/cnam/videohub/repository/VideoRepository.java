package org.cnam.videohub.repository;


import org.cnam.videohub.domain.entity.Category;
import org.cnam.videohub.repository.model.CategoryModel;
import org.cnam.videohub.repository.model.VideoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<VideoModel, Long> {

    List<VideoModel> findAllByCategory(CategoryModel categoryModel);

}
