package de.pizzabot.input

data class Choice<ItemType>(val id: String, val description: String, val item: ItemType)

interface Input {
    fun prompt(text: String): String
    fun <I> prompt(text: String, choices: Collection<Choice<I>>): Choice<I>?
}