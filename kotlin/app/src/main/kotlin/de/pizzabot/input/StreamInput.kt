package de.pizzabot.input

import de.pizzabot.display.Display
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


class StreamInput(private val display: Display, inputStream: InputStream) : Input {
    private val exitId = "0"
    private val exitDescription = "Exit"

    private val input = BufferedReader(InputStreamReader(inputStream))

    override fun prompt(text: String): String {
        display.display(text)
        return input.readLine()
    }

    override fun <I> prompt(text: String, choices: Collection<Choice<I>>): Choice<I>? {
        displayChoices(text, choices)
        var userInput = input.readLine()

        while (!inputValid(choices, userInput)) {
            display.display("Invalid input. Please pick from available choices")
            displayChoices(text, choices)
            userInput = input.readLine()
        }

        return findMatchingChoice(choices, userInput)
    }

    private fun <I> displayChoices(text: String, choices: Collection<Choice<I>>) {
        val choicesDisplay = choices.joinToString(", ") { c -> "${c.id}=${c.description}" }
        display.display("$text [$exitId=$exitDescription, $choicesDisplay]")
    }

    private fun <I> findMatchingChoice(choices: Collection<Choice<I>>, input: String?): Choice<I>? {
        return if (input != null) {
            choices.find { c -> c.id == input }
        } else {
            null
        }
    }

    private fun <I> inputValid(choices: Collection<Choice<I>>, input: String?): Boolean =
        findMatchingChoice(choices, input) != null || isExit(input)

    private fun isExit(id: String?) = id != null && id == exitId
}