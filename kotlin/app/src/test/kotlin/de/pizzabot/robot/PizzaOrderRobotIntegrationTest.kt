package de.pizzabot.robot

import de.pizzabot.basetypes.Order
import de.pizzabot.basetypes.Prices
import de.pizzabot.display.Display
import de.pizzabot.display.StreamDisplay
import de.pizzabot.ingredients.*
import de.pizzabot.input.Input
import de.pizzabot.input.StreamInput
import de.pizzabot.pizzas.Margerita
import de.pizzabot.pizzas.Standard
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.hasSize
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import java.io.ByteArrayOutputStream

class PizzaOrderRobotIntegrationTest {
    val ls = System.lineSeparator()
    val mockDisplay = mock<Display>()
    val mockInput = mock<Input>()
    val mockPrices = mock<Prices>()

    @Test
    fun `Display menu`() {
        // arrange
        val expected = getMenuGoldenOutput()
        val outputBuffer = ByteArrayOutputStream()
        val output = StreamDisplay(outputBuffer)
        val testObject = PizzaOrderRobot(output, mockInput, mockPrices)

        // act
        testObject.displayMenu()

        // assert
        assertThat(String(outputBuffer.toByteArray()), equalTo(expected))
    }

    @Test
    fun `Order pizza with everything`() {
        // arrange
        val inputData = getSelectAllInput()
        val input = StreamInput(mockDisplay, inputData.byteInputStream())
        val testObject = PizzaOrderRobot(mockDisplay, input, mockPrices)
        whenever(mockPrices.getPriceFor(any())).thenReturn(1.0)

        // act
        val result = testObject.collectOrders()

        // assert
        assertThat(result, hasSize(1))
        assertThat(result.first().pizza.getName(), equalTo("Margerita"))
        assertThat(result.first().dough.getName(), equalTo("Standard"))
        assertThat(result.first().extras, hasSize(7))
    }

    @Test
    fun `Order pizza with no extras`() {
        // arrange
        val inputData = "2${ls}2${ls}0${ls}"
        val input = StreamInput(mockDisplay, inputData.byteInputStream())
        val testObject = PizzaOrderRobot(mockDisplay, input, mockPrices)
        whenever(mockPrices.getPriceFor(any())).thenReturn(1.0)

        // act
        val result = testObject.collectOrders()

        // assert
        assertThat(result, hasSize(1))
        assertThat(result.first().pizza.getName(), equalTo("Salami"))
        assertThat(result.first().dough.getName(), equalTo("Cheese Crust"))
        assertThat(result.first().extras, hasSize(0))
    }

    @Test
    fun `Bake a simple pizza with all extras`() {
        val expected = getBakingGoldenOutput()
        val outputBuffer = ByteArrayOutputStream()
        val output = StreamDisplay(outputBuffer)
        val testObject = PizzaOrderRobot(output, mockInput, mockPrices)
        val order = Order(
            Margerita(),
            Standard(),
            listOf(Ham(), Cheese(), Mozzarella(), Pineapple(), Salami(), TomatoSauce(), Tuna())
        )

        // act
        testObject.bakePizza(order)

        // assert
        assertThat(String(outputBuffer.toByteArray()), equalTo(expected))
    }

    @Test
    fun `Show the bill for a Pizza with everything`() {
        val expected = getBillGoldenOutput()
        val outputBuffer = ByteArrayOutputStream()
        val output = StreamDisplay(outputBuffer)
        val testObject = PizzaOrderRobot(output, mockInput, StandardPrices)
        val order = Order(
            Margerita(),
            Standard(),
            listOf(Ham(), Cheese(), Mozzarella(), Pineapple(), Salami(), TomatoSauce(), Tuna())
        )

        // act
        testObject.displayBill(order)

        // assert
        assertThat(String(outputBuffer.toByteArray()), equalTo(expected))
    }

    private fun getSelectAllInput() = "1${ls}1${ls}1${ls}2${ls}3${ls}4${ls}5${ls}6${ls}7${ls}0${ls}"

    private fun getMenuGoldenOutput(): String =
        "Menu:${ls}================${ls}-- Margerita            | 0.0${ls}-- Salami               | 0.0${ls}-- Tuna                 | 0.0${ls}"

    private fun getBakingGoldenOutput(): String =
        "Baking Pizza: Margerita${ls}--> kneading standard dough${ls}--> slicing ham${ls}--> grating cheese${ls}--> pulling mozzarella into strips${ls}--> really? pineapple? *sigh*${ls}--> cutting salami into slices${ls}--> cooking tomato sauce${ls}--> fishing for tuna${ls}"

    private fun getBillGoldenOutput(): String =
        "Time to pay:${ls}================${ls}## Margerita            | 8.29${ls}##   Standard           | 0.89${ls}##   Ham                | 0.79${ls}##   Cheese             | 0.59${ls}##   Mozzarella         | 0.79${ls}##   Pineapple (Yuck!)  | 99.99${ls}##   Salami             | 0.69${ls}##   Tomate Sauce       | 0.29${ls}##   Tuna               | 1.09${ls}## -- TOTAL:            | 113.41${ls}"

}
