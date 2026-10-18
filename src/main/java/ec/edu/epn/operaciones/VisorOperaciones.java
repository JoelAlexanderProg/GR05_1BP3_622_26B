package ec.edu.epn.operaciones;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Muestra en la terminal las operaciones de la calculadora con dos números.
 */
public class VisorOperaciones {

    // Hasta cuatro decimales, con punto decimal en cualquier equipo
    private static final DecimalFormat FORMATO =
            new DecimalFormat("0.####", DecimalFormatSymbols.getInstance(Locale.ROOT));

    private final Calculadora calculadora;
    private final Terminal terminal;

    public VisorOperaciones(Calculadora calculadora, Terminal terminal) {
        this.calculadora = calculadora;
        this.terminal = terminal;
    }

    public void mostrarOperaciones(double a, double b) {
        terminal.mostrar("Operaciones con " + formatear(a) + " y " + formatear(b));
        mostrar(a, "+", b, calculadora.sumar(a, b));
        mostrar(a, "-", b, calculadora.restar(a, b));
        mostrar(a, "*", b, calculadora.multiplicar(a, b));
        try {
            mostrar(a, "/", b, calculadora.dividir(a, b));
        } catch (ArithmeticException e) {
            terminal.mostrar(formatear(a) + " / " + formatear(b) + " -> " + e.getMessage());
        }
    }

    private void mostrar(double a, String operador, double b, double resultado) {
        terminal.mostrar(formatear(a) + " " + operador + " " + formatear(b) + " = " + formatear(resultado));
    }

    private static String formatear(double numero) {
        // Sumar 0.0 convierte -0.0 en 0.0, para no mostrar "-0"
        return FORMATO.format(numero + 0.0);
    }
}
