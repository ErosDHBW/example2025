package de.pizzabot.robot

import de.pizzabot.basetypes.Order

interface OrderReveicer {
    fun collectOrders(): Collection<Order>
}