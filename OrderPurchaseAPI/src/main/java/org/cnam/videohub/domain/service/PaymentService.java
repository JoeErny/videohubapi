package org.cnam.videohub.domain.service;


import org.cnam.videohub.domain.entity.Order;
import org.cnam.videohub.domain.entity.Payment;
import org.cnam.videohub.domain.entity.PaymentToCreate;
import org.cnam.videohub.repository.PaymentRepository;
import org.cnam.videohub.repository.model.OrderModel;
import org.cnam.videohub.repository.model.PaymentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderService orderService;

    public Payment getById(Long id)
    {
        PaymentModel paymentModel = paymentRepository.getOne(id);
        return new Payment(paymentModel.getId() , paymentModel.getOrder().getId(), paymentModel.getAmount(), paymentModel.getDate()) ;
    }

    public Payment commitPayment(PaymentToCreate paymentToCreate) {

        Order orderConcerned = orderService.getById(paymentToCreate.orderId);
        PaymentModel paymentModelSaved = paymentRepository.save(new PaymentModel(paymentToCreate.amount, new Date(), new OrderModel(paymentToCreate.orderId)));
        Payment paymentSaved =  new Payment(paymentModelSaved.getId(), paymentModelSaved.getOrder().getId(), paymentModelSaved.getAmount(), paymentModelSaved.getDate());
        orderConcerned.payment_status = orderService.getPaymentStatusOfOrder(paymentToCreate.orderId);
        orderService.update(orderConcerned);

        return paymentSaved;
    }

    public Payment createNewPayment(PaymentToCreate paymentToCreate) {
        Order orderConcerned = orderService.getById(paymentToCreate.orderId);
        PaymentModel paymentModelSaved = paymentRepository.save(new PaymentModel(paymentToCreate.amount, new Date(), new OrderModel(paymentToCreate.orderId)));
        return new Payment(paymentModelSaved.getId(), paymentModelSaved.getOrder().getId(), paymentModelSaved.getAmount(), paymentModelSaved.getDate());
    }

}
