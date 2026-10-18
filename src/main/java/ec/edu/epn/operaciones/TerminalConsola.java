package ec.edu.epn.operaciones;

/**
 * Terminal real: escribe cada línea en la consola.
 */
public class TerminalConsola implements Terminal {

    @Override
    public void mostrar(String linea) {
        System.out.println(linea);
    }
}
