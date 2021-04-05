package org.cnam.videohub.domain.service;

import org.cnam.videohub.domain.entity.Order;
import org.cnam.videohub.domain.entity.OrderToCreate;
import org.cnam.videohub.repository.OrderRepository;
import org.cnam.videohub.repository.PaymentRepository;
import org.cnam.videohub.repository.model.OrderModel;
import org.cnam.videohub.repository.model.PaymentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Order getById(Long id) {

        OrderModel orderModelFound = orderRepository.getOne(id);
        return new Order(orderModelFound.getId(), orderModelFound.getDate(), orderModelFound.getPrice(), orderModelFound.getUserId(), orderModelFound.getVideoId(), orderModelFound.getStatus());
    }

    public Order create(OrderToCreate orderToCreate) {

            OrderModel entityOrderToCreate = new OrderModel( orderToCreate.getDate(), orderToCreate.getPrice(), orderToCreate.getUser_id(), orderToCreate.getVideo_id(), PaymentStatusEnum.UNPAID.name());
            OrderModel entityOrderCreated = orderRepository.save(entityOrderToCreate);
            return new Order(entityOrderCreated.getId(), entityOrderCreated.getDate(), entityOrderCreated.getPrice(), entityOrderCreated.getUserId(), entityOrderCreated.getVideoId(), entityOrderCreated.getStatus());

  }
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
    //TODO Demander : Le produit doit-il etre rajouté dans la classe ORDER ou doit il être récupéré de l'ENTITY_ORDER ?
    public Order update(Order orderToUpdate) {
        OrderModel entityOrderToUpdate = new OrderModel(orderToUpdate.getId(), orderToUpdate.getDate(), orderToUpdate.getPrice(), orderToUpdate.user_id, orderToUpdate.video_id, orderToUpdate.payment_status);
        OrderModel entityOrderUpdated = orderRepository.save(entityOrderToUpdate);
        return new Order(entityOrderUpdated.getId(), entityOrderUpdated.getDate(), entityOrderUpdated.getPrice(), entityOrderUpdated.getUserId(), entityOrderUpdated.getVideoId(), entityOrderToUpdate.getStatus());
    }

    public String getPaymentStatusOfOrder(Long orderId) {
        Double paymentsTotal = 0.0;
        Order orderConcerned = getById(orderId);
        String paymentStatus = orderConcerned.getPayment_status();

        List<PaymentModel> listPayments = paymentRepository.findAllByOrder(new OrderModel(orderId));
        for (PaymentModel payment : listPayments
        )
        {
            paymentsTotal+=payment.getAmount();
        }

        if(paymentsTotal >= orderConcerned.getPrice())
        {
            paymentStatus = PaymentStatusEnum.PAID.name();
        }
        else if(paymentsTotal<orderConcerned.getPrice())
        {
            paymentStatus = PaymentStatusEnum.PARTIALLY.name();
        }
        else
        {
            paymentStatus = PaymentStatusEnum.UNPAID.name();
        }

        return paymentStatus;
    }

    public Order defineStatus(Order order)
    {
        order.setPayment_status(getPaymentStatusOfOrder(order.id));
        update(order);
        return order;
    }



}
