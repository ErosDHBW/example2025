package de.pizzabot.display

import de.pizzabot.basetypes.Preparable

interface Display {
    fun display(line: String)
    fun displayMenuItem(name: String, price: Double = 0.0)
    fun displayPreparationStep(preparable: Preparable)
    fun displayBillLine(item: String, price: Double)
}