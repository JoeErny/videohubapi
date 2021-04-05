package org.cnam.videohub.domain.service;

import org.cnam.videohub.controller.dto.orderpurchase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class OrderPurchaseService {


    @Autowired
    private BrowsingVideoService browsingVideoService;

    private final static String purchaseOrderUrl = "http://localhost:8083/videohub/rest/orderpurchase/create";
    private final static String makeOrderUrl = "http://localhost:8083/videohub/rest/order/create";


    public OrderPurchaseResponse purchaseOrder(OrderPurchaseRequest orderPurchaseRequest) {

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<OrderPurchaseRequest> orderPurchaseRequestHttp = new HttpEntity<>(orderPurchaseRequest);
        return restTemplate.postForObject(purchaseOrderUrl, orderPurchaseRequestHttp, OrderPurchaseResponse.class);
    }

    public OrderResponse makeOrder(MakeOrderRequest makeOrderRequest) {

        OrderRequest orderRequest = new OrderRequest(new Date(), browsingVideoService.getVideoById(makeOrderRequest.video_id).price, makeOrderRequest.video_id, makeOrderRequest.user_id);
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<OrderRequest> orderRequestHttp = new HttpEntity<>(orderRequest);
        return restTemplate.postForObject(makeOrderUrl, orderRequestHttp, OrderResponse.class);
    }

}
