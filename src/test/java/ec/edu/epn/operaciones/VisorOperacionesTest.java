package ec.edu.epn.operaciones;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * La terminal es un mock de Mockito: la prueba no escribe en la consola,
 * solo verifica qué líneas se le pidió mostrar y en qué orden.
 */
@ExtendWith(MockitoExtension.class)
class VisorOperacionesTest {

    @Mock
    private Terminal terminal;

    private VisorOperaciones visor;

    @BeforeEach
    void crearVisor() {
        visor = new VisorOperaciones(new Calculadora(), terminal);
    }

    @Test
    @DisplayName("Muestra las cinco operaciones en la terminal, en orden")
    void muestraLasCincoOperaciones() {
        visor.mostrarOperaciones(12, 4);

        InOrder enOrden = inOrder(terminal);
        enOrden.verify(terminal).mostrar("Operaciones con 12 y 4");
        enOrden.verify(terminal).mostrar("12 + 4 = 16");
        enOrden.verify(terminal).mostrar("12 - 4 = 8");
        enOrden.verify(terminal).mostrar("12 * 4 = 48");
        enOrden.verify(terminal).mostrar("12 / 4 = 3");
        enOrden.verify(terminal).mostrar("12 ^ 4 = 20736");
        verifyNoMoreInteractions(terminal);
    }

    @Test
    @DisplayName("Muestra los decimales con punto")
    void muestraLosDecimalesConPunto() {
        visor.mostrarOperaciones(7.5, 2);

        verify(terminal).mostrar("7.5 / 2 = 3.75");
    }

    @Test
    @DisplayName("Avisa que no se puede dividir para cero, sin detenerse")
    void avisaQueNoSePuedeDividirParaCero() {
        visor.mostrarOperaciones(12, 0);

        verify(terminal).mostrar("12 * 0 = 0");
        verify(terminal).mostrar("12 / 0 -> no se puede dividir para cero");
        verify(terminal).mostrar("12 ^ 0 = 1");
    }

    @Test
    @DisplayName("Muestra si la potencia queda indefinida o es infinita")
    void muestraPotenciaIndefinidaOInfinita() {
        visor.mostrarOperaciones(-8, 0.5);
        visor.mostrarOperaciones(10, 400);

        verify(terminal).mostrar("-8 ^ 0.5 = indefinido");
        verify(terminal).mostrar("10 ^ 400 = infinito");
    }
}
