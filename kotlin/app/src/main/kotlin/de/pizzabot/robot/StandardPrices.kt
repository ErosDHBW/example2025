package de.pizzabot.robot

import de.pizzabot.basetypes.Priceable
import de.pizzabot.basetypes.Prices
import de.pizzabot.ingredients.Ingredient
import de.pizzabot.pizzas.Dough
import de.pizzabot.pizzas.Pizza

object StandardPrices : Prices {
    override fun getPriceFor(priceable: Priceable): Double {
        val priceList = when (priceable) {
            is Pizza, is Dough -> de.pizzabot.pizzas.StandardPrices
            is Ingredient -> de.pizzabot.ingredients.StandardPrices
            else -> throw IllegalArgumentException("What are you talking about?")
        }

        return priceList.getPriceFor(priceable)
    }
}