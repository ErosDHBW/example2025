package de.pizzabot.pizzas

import de.pizzabot.basetypes.Priceable
import de.pizzabot.basetypes.Prices
import de.pizzabot.basetypes.UnknownPriceableException

object StandardPrices : Prices {
    override fun getPriceFor(priceable: Priceable): Double {
        return when (priceable) {
            is Pizza -> getPriceForPizza(priceable)
            is Dough -> getPriceForDough(priceable)
            else -> throw UnknownPriceableException()
        }
    }

    private fun getPriceForPizza(pizza: Pizza): Double {
        return when (pizza) {
            is Margerita -> 8.29
            is Salami, is Tuna -> 9.59
            else -> throw UnknownPriceableException()
        }
    }

    private fun getPriceForDough(dough: Dough): Double {
        return when (dough) {
            is Standard -> 0.89
            is CheeseCrust -> 2.59
            is WholeWheat -> 0.99
            else -> throw UnknownPriceableException()
        }
    }
}