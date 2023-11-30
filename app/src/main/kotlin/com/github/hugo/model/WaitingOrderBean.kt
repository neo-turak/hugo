package com.github.hugo.model


class WaitingOrderBean : ArrayList<WaitingOrderBean.WaitingOrderBeanItem>() {
    data class WaitingOrderBeanItem(
        val orderDetailsEntityList: List<OrderDetailsEntity>,
        val orderEntity: OrderEntity
    ) {
        data class OrderDetailsEntity(
            val enable: Int, // 1
            val foodId: Int, // 7
            val orderId: Int, // 0
            val orderItemId: Int, // 1
            val price: Double, // 6.30
            val quantity: Int, // 1
            val shopId: Int // 1
        )

        data class OrderEntity(
            val customerId: Int, // 1
            val delete: Int, // 0
            val deliverId: Any, // null
            val enable: Int, // 1
            val ooid: Int, // 0
            val orderDate: String, // 2023-07-12
            val price: Double, // 26.00
            val shopId: Int // 1
        )
    }
}