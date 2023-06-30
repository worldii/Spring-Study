package com.example.springjpapractice.service;

import com.example.springjpapractice.domain.Delivery;
import com.example.springjpapractice.domain.Member;
import com.example.springjpapractice.domain.Order;
import com.example.springjpapractice.domain.OrderItem;
import com.example.springjpapractice.domain.item.Item;
import com.example.springjpapractice.repository.ItemRepository;
import com.example.springjpapractice.repository.MemberRepository;
import com.example.springjpapractice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public Long order(Long memberId, Long itemId, int count) {

        Member member = memberRepository.findOne(memberId);

        Item item = itemRepository.findOne(itemId);

        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        Order order = Order.createOrder(member, delivery, orderItem);

        orderRepository.save(order);
        return order.getId();
    }

    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.cancel();
    }

//    public List<Order> findOrders(OrderSearch orderSearch) {
//        return orderRepository.findAll(orderSearch);
//    }


}
