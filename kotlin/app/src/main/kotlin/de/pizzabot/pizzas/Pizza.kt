package de.pizzabot.pizzas

import de.pizzabot.basetypes.Named
import de.pizzabot.basetypes.Priceable
import de.pizzabot.ingredients.Ingredient

sealed interface Pizza : Named, Priceable {
    fun getIngredients(): Collection<Ingredient>
}