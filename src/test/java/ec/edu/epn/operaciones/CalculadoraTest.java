package ec.edu.epn.operaciones;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculadoraTest {

    private static final double MARGEN = 1e-9;

    private final Calculadora calculadora = new Calculadora();

    @Test
    @DisplayName("Suma dos números")
    void sumaDosNumeros() {
        assertEquals(16, calculadora.sumar(12, 4), MARGEN);
    }

    @Test
    @DisplayName("Resta dos números")
    void restaDosNumeros() {
        assertEquals(8, calculadora.restar(12, 4), MARGEN);
    }

    @Test
    @DisplayName("Multiplica dos números")
    void multiplicaDosNumeros() {
        assertEquals(48, calculadora.multiplicar(12, 4), MARGEN);
    }

    @Test
    @DisplayName("Divide dos números")
    void divideDosNumeros() {
        assertEquals(3, calculadora.dividir(12, 4), MARGEN);
    }

    @Test
    @DisplayName("No permite dividir para cero")
    void noPermiteDividirParaCero() {
        ArithmeticException error = assertThrows(ArithmeticException.class, () -> calculadora.dividir(12, 0));
        assertEquals("no se puede dividir para cero", error.getMessage());
    }

    @ParameterizedTest(name = "{0} ^ {1} = {2}")
    @CsvSource({
            "12, 4, 20736",
            "2, 10, 1024",
            "2, -1, 0.5",
            "7, 0, 1"
    })
    @DisplayName("Eleva un número a una potencia")
    void elevaAUnaPotencia(double base, double exponente, double resultado) {
        assertEquals(resultado, calculadora.potencia(base, exponente), MARGEN);
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "-2, 3, 1",
            "0.5, 0.25, 0.75",
            "-1.5, -1.5, -3"
    })
    @DisplayName("Suma números negativos y decimales")
    void sumaNegativosYDecimales(double a, double b, double resultado) {
        assertEquals(resultado, calculadora.sumar(a, b), MARGEN);
    }
}
