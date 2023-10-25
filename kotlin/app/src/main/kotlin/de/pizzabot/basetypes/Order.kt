package de.pizzabot.basetypes

import de.pizzabot.ingredients.Ingredient
import de.pizzabot.pizzas.Dough
import de.pizzabot.pizzas.Pizza

data class Order(val pizza: Pizza, val dough: Dough, val extras: Collection<Ingredient>) {
    override fun toString(): String {
        return "Pizza: ${pizza.getName()} on ${dough.getName()} dough; Extras: ${
            extras.joinToString(
                ", ",
                transform = Ingredient::getName
            )
        }"
    }
}
