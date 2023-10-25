package de.pizzabot.ingredients

import de.pizzabot.basetypes.Named
import de.pizzabot.basetypes.Preparable
import de.pizzabot.basetypes.Priceable

sealed interface Ingredient : Named, Preparable, Priceable {
}