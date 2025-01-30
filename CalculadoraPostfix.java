import java.util.Scanner;

/**
 * Clase que implementa a la calculadora para evaluar expresiones en notación postfix.
 */
public class CalculadoraPostfix {
    private Stack<Integer> stack;

    /**
     * Constructor 
     */
    public CalculadoraPostfix() {
        //Llamamos a nuestro querido stack
        stack = new StackVector<>();
    }

    /**
     * Evalúa una expresión en notación postfix y devuelve el resultado
     * @param operacion La expresión en notacion postfix a evaluar.
     * @return El resultado de la operacion.
     */
    public int evaluar(String operacion) {
        Scanner scanner = new Scanner(operacion);

        // Mientras halla algun dato en el scanner:
        while (scanner.hasNext()) {
            // Si el siguiente dato es un entero:
            if (scanner.hasNextInt()) {
                stack.push(scanner.nextInt()); //Metemos el entero en la pila
            } else {
                /**
                 * hacer pop dos veces por los dos operandos, operamos y hacemos push del resultado
                 * Funciona para varios operadores porque no termina hasta que deja de haber datos, y el resultado se mete directamente en el stack para su uso.
                 */
                String operador = scanner.next();
                int operandoB = stack.pop();
                int operandoA = stack.pop();
                int result = operar(operandoA,operandoB,operador);
                stack.push(result);
            }
        }
        scanner.close();
        return stack.pop();
    }

    /**
     * Realiza una operación matemática entre dos operandos dados un operador.
     * @param operandoA El primer operando y @param operandoB El segundo operando.
     * @param operador  El operador que se unira a los operandos
     * @return El resultado de la operación.
     * @throws ArithmeticException Si se intenta dividir entre cero.
     * @throws IllegalArgumentException Si el operador no es válido.
     */
    private int operar(int operandoA, int operandoB, String operador) {
        // Segun cada posible operador:
        switch (operador) {
            case "+":
                return operandoA + operandoB;
            case "-":
                return operandoA - operandoB;
            case "*":
                return operandoA * operandoB;
            case "/":
                if (operandoB == 0) throw new ArithmeticException("Division por cero, regresenlo al colegio");
                return operandoA / operandoB;
            case "%":
                return operandoA % operandoB;
            default:
                throw new IllegalArgumentException("Este operador no existe brother: " + operador);
        }
    }
}

