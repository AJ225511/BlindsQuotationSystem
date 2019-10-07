package wiese.domains.Order;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class Order {
    
    @Id
    private String orderId, orderDate, orderItems;
    @OneToMany()
    private String desc;

    public Order() {
    }

    public Order(Builder builder) {
        this.orderId = builder.orderId;
        this.orderDate = builder.orderDate;
        this.orderItems = builder.orderItems;
        this.desc = builder.desc;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate(){
        return orderDate;
    }

    public String getOrderItems(){
        return orderItems;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                "orderDate='" + orderDate + '\'' +
                "orderItems='" + orderItems + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String orderId,orderDate,orderItems, desc;

        public Builder orderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder orderDate(String orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder orderItems(String orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(Order order){
            this.orderId = order.orderId;
            this.orderDate= order.orderDate;
            this.orderItems=order.orderItems;
            this.desc = order.desc;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

}

