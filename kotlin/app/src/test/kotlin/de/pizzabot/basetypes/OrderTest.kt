package de.pizzabot.basetypes

import de.pizzabot.ingredients.Cheese
import de.pizzabot.ingredients.Ham
import de.pizzabot.ingredients.Tuna
import de.pizzabot.pizzas.Margerita
import de.pizzabot.pizzas.Standard
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import kotlin.test.Test

class OrderTest {
    @Test
    fun `Stringify a Pizza, a dough and 3 extras`() {
        // arrange
        val pizza = Margerita()
        val dough = Standard()
        val extras = listOf(Ham(), Cheese(), Tuna())
        val order = Order(pizza, dough, extras)

        // act
        val result = order.toString()

        // assert
        assertThat(result, equalTo("Pizza: Margerita on Standard dough; Extras: Ham, Cheese, Tuna"))
    }

    @Test
    fun `Stringify a Pizza and a dough but no extras`() {
        // arrange
        val pizza = Margerita()
        val dough = Standard()
        val order = Order(pizza, dough, listOf())

        // act
        val result = order.toString()

        // assert
        assertThat(result, equalTo("Pizza: Margerita on Standard dough; Extras: "))
    }

    @Test
    fun `Stringify a Salami Pizza with Cheesy Crust and Mozzarella`() {
        TODO("Not yet implemented")
    }
}