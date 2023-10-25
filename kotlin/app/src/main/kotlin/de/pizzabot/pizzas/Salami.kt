package de.pizzabot.pizzas

import de.pizzabot.ingredients.Cheese
import de.pizzabot.ingredients.Ingredient
import de.pizzabot.ingredients.TomatoSauce

class Salami : Pizza {
    override fun getName(): String = "Salami"

    override fun getIngredients(): Collection<Ingredient> =
        listOf(TomatoSauce(), Cheese(), de.pizzabot.ingredients.Salami())
}