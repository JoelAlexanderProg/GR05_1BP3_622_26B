# GR05_1BP3_622_26B: operaciones matemáticas en la terminal

Práctica 3 de Metodologías Ágiles (ISWD622, EPN, 2026-B), Grupo 5: integración continua de un proyecto Java con Maven, JUnit y Mockito.

**Historia de usuario:** como usuario deseo visualizar operaciones matemáticas desde una terminal.

## Tecnologías

| Uso | Tecnología |
|---|---|
| Lenguaje | Java 17 o superior |
| Construcción | Maven (con el wrapper `mvnw`, no hace falta instalarlo) |
| Pruebas unitarias | JUnit 5 y Mockito |

## Estructura

```
src/main/java/ec/edu/epn/operaciones/
├── Calculadora.java        suma, resta, multiplica, divide y eleva a una potencia
├── Terminal.java           interfaz para mostrar líneas de texto
├── TerminalConsola.java    terminal real: escribe en la consola
├── VisorOperaciones.java   muestra en la terminal las operaciones con dos números
└── Aplicacion.java         punto de entrada del JAR
src/test/java/ec/edu/epn/operaciones/
├── CalculadoraTest.java       pruebas unitarias con JUnit (dos de ellas con parámetros)
└── VisorOperacionesTest.java  pruebas con Mockito: la terminal es un objeto simulado
```

## Cómo construir y ejecutar

Solo se necesita Java 17 o superior. Desde la carpeta del proyecto, Maven compila, ejecuta las pruebas y genera el JAR en `target/`:

    .\mvnw.cmd clean package      (Windows)
    ./mvnw clean package          (Linux o macOS)

Luego, en la terminal, se indican los dos números:

    java -jar target/GR05_1BP3_622_26B.jar 12 4

```
Operaciones con 12 y 4
12 + 4 = 16
12 - 4 = 8
12 * 4 = 48
12 / 4 = 3
12 ^ 4 = 20736
```

Sin números, usa 12 y 4 como ejemplo.

## Cómo ejecutar solo las pruebas

    .\mvnw.cmd test      (Windows)
    ./mvnw test          (Linux o macOS)

## Integrantes

- Lenin Alejandro Jerez Chimbo
- Dylan Isaí Maldonado Morales
- Joel Alexander Places Lucero
- Jeimy Jhair Sánchez Tixe
- Francisco Gabriel Villalba Portilla
