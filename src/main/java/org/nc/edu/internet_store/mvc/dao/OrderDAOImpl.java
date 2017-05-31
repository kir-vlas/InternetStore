package org.nc.edu.internet_store.mvc.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.nc.edu.internet_store.mvc.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    SessionFactory sessionFactory;

    public void saveOrder(Cart cart, Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Order order = new Order();
        order.setDate(new Date());
        order.setClient(account);
        order.setStatus(1);
        order.setTotalPrice(cart.getAmountTotal());
        List<CartLine> lines = cart.getGoodsList();
        session.persist(order);
        for (CartLine line: lines){
            OrderLine orderLine = new OrderLine();
            orderLine.setGood(line.getGood().getId());
            orderLine.setQuantity(line.getQuantity());
            orderLine.setOrder(order);
        }
        session.close();
    }


    public List<OrderLine> listOrderLine(Integer id) {
        return null;
    }

    public Order findOrder(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Order.class);
        crit.add(Restrictions.eq("id", id));
        return (Order) crit.uniqueResult();
    }
}
