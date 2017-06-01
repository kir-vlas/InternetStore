package org.nc.edu.internet_store.mvc.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.nc.edu.internet_store.mvc.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    SessionFactory sessionFactory;

    public void saveOrder(Cart cart) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Order order = new Order();
        order.setDate(new Date());
        order.setClient(cart.getClient());
        order.setStatus(1);
        order.setTotalPrice(cart.getAmountTotal());
        List<CartLine> lines = cart.getGoodsList();
        session.persist(order);
        for (CartLine line: lines){
            OrderLine orderLine = new OrderLine();
            orderLine.setGood(line.getGood());
            orderLine.setQuantity(line.getQuantity());
            orderLine.setOrder(order);
            session.persist(orderLine);
        }
        cart.setOrderId(order.getId());
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<OrderList> listOrderByClient(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<OrderList> orderList = new ArrayList<>();
        String query = "select o from Order o where o.client.id = "+account.getId();
        List<Order> orders = session.createQuery(query).list();
        for (Order order : orders){
            query = "select ol from OrderLine ol where ol.order.id = "+order.getId();
            List<OrderLine> orderLines = session.createQuery(query).list();
            OrderList orderListl = new OrderList();
            orderListl.setOrder(order);
            orderListl.setOrderLines(orderLines);
            orderList.add(orderListl);
        }
        return orderList;
    }

    public Order findOrder(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Order.class);
        crit.add(Restrictions.eq("id", id));
        return (Order) crit.uniqueResult();
    }
}
