import java.util.Scanner;
import java.util.Stack;

public class CalculadoraPostfix implements Interfaz {
    private Stack<Integer> stack;

    // Constructor
    public CalculadoraPostfix() {
        stack = new Stack<>(); // Usamos Stack<Integer> de Java
    }

    @Override
    public int evaluar(String operacion) {
        Scanner scanner = new Scanner(operacion);

        // Mientras haya algún dato en el scanner:
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                stack.push(scanner.nextInt()); // Metemos el entero en la pila
            } else {
                // Extraemos el operador y operamos con los últimos dos valores en la pila
                String operador = scanner.next();
                if (stack.size() < 2) {
                    throw new IllegalStateException("Expresión inválida: faltan operandos.");
                }
                int operandoB = stack.pop();
                int operandoA = stack.pop();
                int resultado = operar(operandoA, operandoB, operador);
                stack.push(resultado);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException("Expresión inválida: demasiados operandos.");
        }

        return stack.pop(); // El resultado final queda en la cima de la pila
    }

    @Override
    public int operar(int operandoA, int operandoB, String operador) {
        switch (operador) {
            case "+":
                return operandoA + operandoB;
            case "-":
                return operandoA - operandoB;
            case "*":
                return operandoA * operandoB;
            case "/":
                if (operandoB == 0) {
                    throw new ArithmeticException("Error: División por cero.");
                }
                return operandoA / operandoB;
            case "%":
                return operandoA % operandoB;
            default:
                throw new IllegalArgumentException("Operador no válido: " + operador);
        }
    }
}
