package org.cnam.videohub.domain.service;

import org.cnam.videohub.controller.dto.external_api_module.FidelityPointsAssignmentRequest;
import org.cnam.videohub.controller.dto.external_api_module.FidelityPointsAssignmentResponse;
import org.cnam.videohub.controller.dto.external_api_module.UserResponse;
import org.cnam.videohub.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.tools.ToolProvider;
import javax.transaction.Transactional;

@Service
@Transactional
public class OrderPurchaseService {

    @Autowired
    private PaymentService paymentService;


    @Autowired
    private OrderService orderService;


    private final static String convertAmountToFidelityPointsURL = "http://localhost:8080/videohub/rest/fidelity/assign_points/";

    public OrderPurchaseResult purchaseOrder(OrderToPurchase orderToPurchase) {
        System.out.println(orderToPurchase.amount + "  rtgsrtbsrtbsrtbsh");
        Payment paymentMade = paymentService.createNewPayment(new PaymentToCreate(orderToPurchase.getOrderId(), orderToPurchase.getAmount()));
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<FidelityPointsAssignmentRequest> fidelityPointsAssignmentRequest = new HttpEntity<>(new FidelityPointsAssignmentRequest(orderService.getById(orderToPurchase.orderId).user_id, orderToPurchase.amount));
        FidelityPointsAssignmentResponse fidelityPointsAssignmentResponse = restTemplate.postForObject(convertAmountToFidelityPointsURL, fidelityPointsAssignmentRequest, FidelityPointsAssignmentResponse.class);
        Order orderConcerned = orderService.defineStatus(orderService.getById(orderToPurchase.orderId));
        return new OrderPurchaseResult(paymentMade.id, orderToPurchase.orderId, paymentMade.date, paymentMade.amount, orderConcerned.payment_status, fidelityPointsAssignmentResponse.pointsAdded, fidelityPointsAssignmentResponse.totalUserPoints);

    }
}
