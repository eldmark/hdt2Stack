/**
 * Interface for a Postfix Calculator.
 * Provides methods to evaluate postfix expressions and perform operations.
 */
public interface Interfaz {
    int evaluar(String operacion); // Evaluar la operación y devolver el resultado
    int operar(int operandoA, int operandoB, String operador); // Realizar operación con dos operandos
}
