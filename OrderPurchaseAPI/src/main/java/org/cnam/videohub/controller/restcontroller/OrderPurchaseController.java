package org.cnam.videohub.controller.restcontroller;

import org.cnam.videohub.controller.dto.OrderPurchaseRequest;
import org.cnam.videohub.controller.dto.OrderPurchaseResponse;
import org.cnam.videohub.domain.entity.OrderPurchaseResult;
import org.cnam.videohub.domain.entity.OrderToPurchase;
import org.cnam.videohub.domain.service.OrderPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderpurchase")

public class OrderPurchaseController {

    @Autowired
    OrderPurchaseService orderPurchaseService;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<OrderPurchaseResponse> purchaseOrder(@RequestBody OrderPurchaseRequest orderPurchaseRequest) {



        OrderPurchaseResult orderPurchaseResult = orderPurchaseService.purchaseOrder(new OrderToPurchase(orderPurchaseRequest.getOrderId(), orderPurchaseRequest.getAmount()));
        OrderPurchaseResponse orderPurchaseResponse = new OrderPurchaseResponse(orderPurchaseResult.paymentId, orderPurchaseResult.orderId, orderPurchaseResult.date, orderPurchaseResult.amount, orderPurchaseResult.orderStatus, orderPurchaseResult.fidelityPointsAdded, orderPurchaseResult.getFidelityPointsTotal);
        return new ResponseEntity<>(orderPurchaseResponse, HttpStatus.OK);
    }
}
