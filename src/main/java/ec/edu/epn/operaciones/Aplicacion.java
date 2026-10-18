package ec.edu.epn.operaciones;

/**
 * Punto de entrada del JAR: java -jar GR05_1BP3_622_26B.jar 12 4
 * Sin argumentos, usa 12 y 4 como ejemplo.
 */
public class Aplicacion {

    public static void main(String[] args) {
        Terminal terminal = new TerminalConsola();
        try {
            double a = args.length > 0 ? Double.parseDouble(args[0]) : 12;
            double b = args.length > 1 ? Double.parseDouble(args[1]) : 4;
            new VisorOperaciones(new Calculadora(), terminal).mostrarOperaciones(a, b);
        } catch (NumberFormatException e) {
            terminal.mostrar("Los valores deben ser numeros, por ejemplo: java -jar GR05_1BP3_622_26B.jar 12 4");
            System.exit(1);
        }
    }
}
