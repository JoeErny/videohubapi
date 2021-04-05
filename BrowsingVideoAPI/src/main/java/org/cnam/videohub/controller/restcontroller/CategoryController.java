package org.cnam.videohub.controller.restcontroller;

import org.cnam.videohub.controller.dto.CategoryRequest;
import org.cnam.videohub.controller.dto.CategoryResponse;
import org.cnam.videohub.domain.entity.Category;
import org.cnam.videohub.domain.entity.CategoryToCreate;
import org.cnam.videohub.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable("id") long id) {
        Category categoryFound = categoryService.getById(id);

        CategoryResponse categoryResponse = new CategoryResponse(categoryFound.id,categoryFound.label);

        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryToRequest) {
        CategoryToCreate categoryToCreate = new CategoryToCreate(categoryToRequest.label);
        Category categoryCreated = categoryService.create(categoryToCreate);
        CategoryResponse categoryResponse = new CategoryResponse(categoryCreated.id, categoryCreated.label);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }


}
