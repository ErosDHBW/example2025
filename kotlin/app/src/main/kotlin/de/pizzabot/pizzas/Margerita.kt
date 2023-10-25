package de.pizzabot.pizzas

import de.pizzabot.ingredients.Ingredient
import de.pizzabot.ingredients.Mozzarella
import de.pizzabot.ingredients.TomatoSauce

class Margerita : Pizza {
    override fun getName(): String = "Margerita"

    override fun getIngredients(): Collection<Ingredient> =
        listOf(TomatoSauce(), Mozzarella())
}