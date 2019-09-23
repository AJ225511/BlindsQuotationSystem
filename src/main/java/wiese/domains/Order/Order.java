package wiese.domains.Order;

import java.util.Objects;

public class Order {

    private String orderId, orderDate, orderItems;

    public Order() {
    }

    public Order(Builder builder) {
        this.orderDate = builder.orderDate;
        this.orderId = builder.orderId;
        this.orderItems = builder.orderItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderItems() {
        return orderItems;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public static class Builder {

        private String orderId, orderDate, orderItems;

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

        public Order build() {
            return new Order(this);
        }


    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId: '" + orderId + '\'' +
                ", orderDate: '" + orderDate + '\'' +
                ", orderItems: '" + orderItems + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId.equals(order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}

