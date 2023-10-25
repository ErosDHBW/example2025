package de.pizzabot.input

import de.pizzabot.display.Display
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock

class StreamInputTest {
    val ls = System.lineSeparator()
    val display = mock(Display::class.java)

    @Test
    fun `Receive simple text input`() {
        // arrange
        val input = "Hello Input$ls"
        val testObject = StreamInput(display, input.byteInputStream())

        // act
        val result = testObject.prompt("Ignored")

        // assert
        assertThat(result, equalTo("Hello Input"))
    }

    @Test
    fun `Receive empty input`() {
        // arrange
        val input = ls
        val testObject = StreamInput(display, input.byteInputStream())

        // act
        val result = testObject.prompt("Ignored")

        // assert
        assertThat(result, equalTo(""))
    }

    @Test
    fun `Select from small list`() {
        // arrange
        val choices = listOf(
            Choice("1", "Dog", Integer.valueOf(1)),
            Choice("2", "Cat", Integer.valueOf(2)),
            Choice("3", "Mouse", Integer.valueOf(3))
        )
        val input = "2$ls"
        val testObject = StreamInput(display, input.byteInputStream())

        // act
        val result = testObject.prompt("Ignored", choices)

        // assert
        assertThat(result, not(nullValue()))
        assertThat(result?.id, equalTo("2"))
        assertThat(result?.description, equalTo("Cat"))
        assertThat(result?.item, equalTo(2))
    }

    @Test
    fun `Select from empty list and exit`() {
        // arrange
        val choices: Collection<Choice<String>> = listOf()
        val input = "2${ls}0$ls"
        val testObject = StreamInput(display, input.byteInputStream())

        // act
        val result = testObject.prompt("Ignored", choices)

        // assert
        assertThat(result, nullValue())
    }

}