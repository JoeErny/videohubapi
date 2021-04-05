package org.cnam.videohub.controller.restcontroller;


import org.cnam.videohub.controller.dto.orderpurchase.*;
import org.cnam.videohub.domain.service.OrderPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/placeorder")

public class OrderPurchaseController {

    @Autowired
    OrderPurchaseService orderPurchaseService;

    @PostMapping("/makeandcontinue")
    @ResponseBody
    public ResponseEntity<ContinueToPurchaseResponse> makeOrderAndContinueToPayment(@RequestBody OrderRequest orderRequest) {

        return new ResponseEntity<>(orderPurchaseService.makeOrderAndContinueToPayment(orderRequest), HttpStatus.OK);
    }


    @PostMapping("/make")
    @ResponseBody
    public ResponseEntity<OrderResponse> makeOrder(@RequestBody MakeOrderRequest makeOrderRequest) {

        return new ResponseEntity<>(orderPurchaseService.makeOrder(makeOrderRequest), HttpStatus.OK);
    }
}
