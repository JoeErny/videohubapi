package org.cnam.videohub.repository;

import org.cnam.videohub.repository.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderModel, Long> {

    //List<OrderModel> findAllOrdersByUserAndStatus(UserModel user, String status);
    List<OrderModel> findAllOrdersByUserIdAndStatus(Long userId, String status);
}
