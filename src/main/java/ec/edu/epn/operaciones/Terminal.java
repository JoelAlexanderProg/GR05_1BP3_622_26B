package ec.edu.epn.operaciones;

/**
 * Lugar donde se muestran las operaciones. Al ser una interfaz, las pruebas
 * pueden reemplazar la consola real por un objeto simulado.
 */
public interface Terminal {

    void mostrar(String linea);
}
