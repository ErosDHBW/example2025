package de.pizzabot.basetypes

interface Prices {
    fun getPriceFor(priceable: Priceable): Double
}