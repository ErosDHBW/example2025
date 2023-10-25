package de.pizzabot.display

import de.pizzabot.basetypes.Preparable
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import kotlin.test.Test

class StreamDisplayTest {
    val targetStream = ByteArrayOutputStream();
    var testObject = StreamDisplay(targetStream)
    val ls = System.lineSeparator()

    @BeforeEach
    fun setUp() {
        targetStream.reset()
    }

    @Test
    fun `Write a simple text`() {
        // arrange
        val text = "The quick brown fox jumps over the lazy dog"

        // act
        testObject.display(text)
        val result = getStreamContent()

        // assert
        assertThat(result, equalTo("The quick brown fox jumps over the lazy dog$ls"))
    }

    @Test
    fun `Won't crash with empty input`() {
        // arrange
        val text = ""

        // act
        testObject.display(text)
        val result = getStreamContent()

        // assert
        assertThat(result, equalTo("$ls"))
    }

    @Test
    fun `Print out a menu item with a price`() {
        // arrange
        val itemName = "Frog"
        val itemPrice = 12.34

        // act
        testObject.displayMenuItem(itemName, 12.34)
        val result = getStreamContent()

        // assert
        assertThat(result, equalTo("-- Frog                 | 12.34$ls"))
    }

    @Test
    fun `Print out a menu item with default price`() {
        // arrange
        val itemName = "Frog"

        // act
        testObject.displayMenuItem(itemName)
        val result = getStreamContent()

        // assert
        assertThat(result, equalTo("-- Frog                 | 0.0$ls"))
    }

    @Test
    fun `Display a preparation step`() {
        // arrange
        val step = object : Preparable {
            override fun getPreparationStepDescription(): String =
                "Cook for 38 hours to kill all calories"
        }

        // act
        testObject.displayPreparationStep(step)
        val result = getStreamContent()

        // assert
        assertThat(result, equalTo("--> Cook for 38 hours to kill all calories$ls"))
    }

    @Test
    fun `Display bill line`() {
        // arrange
        val itemName = "Fedora hat"
        val itemPrice = 29.99

        // act
        testObject.displayBillLine(itemName, itemPrice)
        val result = getStreamContent()

        // assert
        assertThat(result, equalTo("## Fedora hat           | 29.99$ls"))
    }

    private fun getStreamContent(): String = String(targetStream.toByteArray())
}