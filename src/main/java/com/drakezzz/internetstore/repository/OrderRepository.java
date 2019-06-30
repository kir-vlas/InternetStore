package com.drakezzz.internetstore.repository;

import com.drakezzz.internetstore.entity.Account;
import com.drakezzz.internetstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByClient(Account account);

}
