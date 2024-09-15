package com.ucb.FrankyService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingServiceTest {

    @Test
    @DisplayName("Verificar que se ha escrito la palabra correcta en inglés")
    void getGreetingInEnglish() {
        ConfigurationParam configurationParamMock = Mockito.mock(ConfigurationParam.class);
        Mockito.when(configurationParamMock.getGreetingMessage("en")).thenReturn(
                "Ask yourself if what you are doing today is getting you closer to where you want to be tomorrow."
        );

        GreetingService greetingService = new GreetingService(configurationParamMock);
        assertEquals(
                "Ask yourself if what you are doing today is getting you closer to where you want to be tomorrow.",
                greetingService.getGreeting("en")
        );
    }

    @Test
    @DisplayName("Verificar que se ha escrito la palabra correcta en español")
    void getGreetingInSpanish() {
        ConfigurationParam configurationParamMock = Mockito.mock(ConfigurationParam.class);
        Mockito.when(configurationParamMock.getGreetingMessage("es")).thenReturn(
                "Pregúntate si lo que estás haciendo hoy te acerca al lugar en el que quieres estar mañana."
        );

        GreetingService greetingService = new GreetingService(configurationParamMock);
        assertEquals(
                "Pregúntate si lo que estás haciendo hoy te acerca al lugar en el que quieres estar mañana.",
                greetingService.getGreeting("es")
        );
    }

    @Test
    @DisplayName("Verificar que el saludo personalizado incluye el nombre en inglés")
    void getPersonalizedGreetingInEnglish() {
        ConfigurationParam configurationParamMock = Mockito.mock(ConfigurationParam.class);
        Mockito.when(configurationParamMock.getGreetingMessage("en")).thenReturn(
                "Ask yourself if what you are doing today is getting you closer to where you want to be tomorrow."
        );

        GreetingService greetingService = new GreetingService(configurationParamMock);
        String name = "John";

        assertEquals(
                "John: Ask yourself if what you are doing today is getting you closer to where you want to be tomorrow.",
                greetingService.getPersonalizedGreeting(name, "en")
        );
    }

    @Test
    @DisplayName("Verificar que el saludo personalizado incluye el nombre en español")
    void getPersonalizedGreetingInSpanish() {
        ConfigurationParam configurationParamMock = Mockito.mock(ConfigurationParam.class);
        Mockito.when(configurationParamMock.getGreetingMessage("es")).thenReturn(
                "Pregúntate si lo que estás haciendo hoy te acerca al lugar en el que quieres estar mañana."
        );

        GreetingService greetingService = new GreetingService(configurationParamMock);
        String name = "Juan";

        assertEquals(
                "Juan: Pregúntate si lo que estás haciendo hoy te acerca al lugar en el que quieres estar mañana.",
                greetingService.getPersonalizedGreeting(name, "es")
        );
    }
}
