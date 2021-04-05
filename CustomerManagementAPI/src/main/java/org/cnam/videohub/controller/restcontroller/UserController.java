package org.cnam.videohub.controller.restcontroller;

import org.cnam.videohub.controller.dto.UserRequest;
import org.cnam.videohub.controller.dto.UserResponse;
import org.cnam.videohub.domain.entity.User;
import org.cnam.videohub.domain.entity.UserToCreate;
import org.cnam.videohub.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<UserResponse> getUser(@PathVariable("id") long id) {
        User userFound = userService.getById(id);

        UserResponse userResponse = new UserResponse(userFound.id, userFound.name, userFound.firstname, userFound.mail, userFound.fidelity_points);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userToRequest) {
        UserToCreate userToCreate = new UserToCreate(userToRequest.name, userToRequest.firstname, userToRequest.mail, userToRequest.fidelity_points);

        User userCreated = userService.create(userToCreate);

        UserResponse userResponse = new UserResponse(userCreated.id, userCreated.name, userCreated.firstname, userCreated.mail, userCreated.fidelity_points);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }




}
