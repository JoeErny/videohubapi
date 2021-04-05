package org.cnam.videohub.controller.restcontroller;

import org.cnam.videohub.controller.dto.FidelityPointsAssignmentRequest;
import org.cnam.videohub.controller.dto.FidelityPointsAssignmentResponse;
import org.cnam.videohub.domain.service.FidelityPointsService;
import org.cnam.videohub.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fidelity")
public class FidelityPointsController {

    @Autowired
    FidelityPointsService fidelityPointsService;

    @Autowired
    UserService userService;

    @PostMapping("/assign_points")
    @ResponseBody
    public ResponseEntity<FidelityPointsAssignmentResponse> createUser(@RequestBody FidelityPointsAssignmentRequest fidelityPointsAssignmentRequest) {

        return new ResponseEntity<>(
                new FidelityPointsAssignmentResponse(fidelityPointsService.convertPaymentAmountToFidelityPoints(
                        fidelityPointsAssignmentRequest.amount, fidelityPointsAssignmentRequest.userId),
                        userService.getById(fidelityPointsAssignmentRequest.userId).fidelity_points), HttpStatus.OK);
    }


}
