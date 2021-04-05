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

    @PostMapping("/purchase_existing_order")
    @ResponseBody
    public ResponseEntity<OrderPurchaseResponse> purchaseExistingOrder(@RequestBody OrderPurchaseRequest orderPurchaseRequest) {

        return new ResponseEntity<>(orderPurchaseService.purchaseOrder(orderPurchaseRequest), HttpStatus.OK);
    }

    @PostMapping("/make")
    @ResponseBody
    public ResponseEntity<OrderResponse> makeOrder(@RequestBody MakeOrderRequest makeOrderRequest) {

        return new ResponseEntity<>(orderPurchaseService.makeOrder(makeOrderRequest), HttpStatus.OK);
    }
}
