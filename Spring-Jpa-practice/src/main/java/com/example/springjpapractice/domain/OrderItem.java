package com.example.springjpapractice.domain;

import com.example.springjpapractice.domain.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "order_item")
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class OrderItem {
    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private Item item;
    private int orderPrice;
    private int count;

    public static OrderItem createOrderItem(Item item, int price, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(price);
        orderItem.setCount(count);
        item.removeStock(count);
        return orderItem;
    }

    // 재고 수량을 원상복구
    public void  cancel() {
        getItem().addStock(count);
    }

    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }
}
