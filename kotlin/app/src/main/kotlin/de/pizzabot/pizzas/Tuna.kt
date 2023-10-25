package de.pizzabot.pizzas

import de.pizzabot.ingredients.Cheese
import de.pizzabot.ingredients.Ingredient
import de.pizzabot.ingredients.TomatoSauce

class Tuna : Pizza {
    override fun getName(): String = "Tuna"

    override fun getIngredients(): Collection<Ingredient> =
        listOf(TomatoSauce(), Cheese(), de.pizzabot.ingredients.Tuna())
}