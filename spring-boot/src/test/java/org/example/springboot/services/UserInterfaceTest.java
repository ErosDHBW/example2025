package org.example.springboot.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.mockito.Matchers.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserInterfaceTest {
    @MockBean
    private Greeter mockGreeter;

    @Autowired
    private UserInterface userInterface;

    @Test
    public void testUserInterface() {
        // Arrange
        Mockito.when(mockGreeter.getGreeting(any())).thenReturn("Greet test");

        // Act
        String greeting = userInterface.returnGreeting("test");

        // Assert
        assertEquals(greeting, "Greet test");
    }
}
