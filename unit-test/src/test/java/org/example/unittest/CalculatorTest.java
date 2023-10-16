package org.example.unittest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.unittest.Calculator;

class CalculatorTest {
    @Test
    void testAddSimpleNumbers() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        int result = calc.add(3, 4);

        // Assert
        assertEquals(7, result);
    }

    @Test
    void testAddZeroes() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        int result = calc.add(0, 0);

        // Assert
        assertEquals(0, result);
    }

    @Test 
    void testAddNegatives() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        int result = calc.add(-3, -4);

        // Assert
        assertEquals(-7, result);
    }

    @Test
    void testAddMixedSign() {
        // Arrange
        Calculator calc = new Calculator();

        // Act
        int result = calc.add(-3, 4);

        // Assert
        assertEquals(1, result);
    }
}
