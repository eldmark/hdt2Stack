/**--------------------------------------
 * Universidad del Valle de Guatemala
 * @author: Pedro Caso 
 * Carnet: 241286
 * Fecha de inicio: 27/01/2025
 * Fecha de finalización: 27/01/2025
 * --------------------------------------
 */

 import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.Scanner;
 
 public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculadoraPostfix calculadoraPF = new CalculadoraPostfix();
        boolean CalcEncendida = true;
 
        while (CalcEncendida) {
            System.out.println("\nOpciones de la calculadora Postfix");
            System.out.println("1. Realizar una operacion (separada por espacios): ");
            System.out.println("2. Leer un archivo de texto: ");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");
             
            String opciones = scanner.nextLine();
            switch (opciones) {
                case "1":
                    System.out.print("Ingresa la operación (separada por espacios): ");
                    String operacion = scanner.nextLine();
                    try {
                        int resultado = calculadoraPF.evaluar(operacion);
                        System.out.println("El resultado de la operación: " + operacion  + " es: " + resultado);
                    } 
                     
                    catch (Exception error) {
                        System.out.println("Hay un error: " + error.getMessage());
                    }
                    break;

                    case "2":
                    System.out.print("Ingresa la ruta del archivo que deseas leer: ");
                    String PathDeArchivo = scanner.nextLine();
                    try (BufferedReader leer = new BufferedReader(new FileReader(PathDeArchivo))) {
                        String linea;
                        System.out.println("Resultados:");
                        while ((linea = leer.readLine()) != null) {
                            try {
                                int resultado = calculadoraPF.evaluar(linea);
                                System.out.println("El resultado de la operación: " + linea + " es: " + resultado);
                            } 

                            catch (Exception error) {
                                System.out.println("Existe un error en la linea/operacion: " + linea + "el error se debe a: " + error.getMessage());
                            }
                        }
                    } 
                    
                    catch (IOException error) {
                        System.out.println("No se pudo leer el archivo: " + error.getMessage());
                    }
                    break;
 
                case "3":
                    System.out.println("Saliendo...");
                    System.out.println("Saliste.");
                    CalcEncendida = false;
                    break;
 
                default:
                    System.out.println("La opción elegida no esta en las funciones. ");
            }
            System.out.println(); 
        }
        scanner.close();
    }
}