package de.pizzabot.pizzas

import de.pizzabot.basetypes.Named
import de.pizzabot.basetypes.Preparable
import de.pizzabot.basetypes.Priceable

sealed interface Dough : Named, Preparable, Priceable {
}