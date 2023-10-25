package de.pizzabot.robot

import de.pizzabot.basetypes.Order

interface PizzaBaker {
    fun bakePizza(pizzaOrder: Order): Unit
}