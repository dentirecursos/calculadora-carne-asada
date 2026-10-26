import java.util.Scanner;

/**
 * Clase: Main
 * Propósito: Clase principal que interactúa con el usuario a través de consola
 * capturando la cantidad de invitados e ingredientes deseados para instanciar
 * la clase CalculadoraCarneAsada y ejecutar sus métodos.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🔥 BIENVENIDO AL ORGANIZADOR DE CARNE ASADA 🔥");
        System.out.println("Responde las siguientes preguntas para armar tu lista de compras:\n");

        // 1. Captura del número de asistentes
        System.out.print("¿Cuántas personas van a asistir? ");
        int personas = scanner.nextInt();

        // 2. Selección interactiva de ingredientes
        System.out.println("\n--- Selección de Ingredientes (Responde 's' para Sí o 'n' para No) ---");

        boolean carne = preguntarOpcion(scanner, "¿Van a comer Carne de Res?");
        boolean chorizo = preguntarOpcion(scanner, "¿Van a comer Chorizo?");
        boolean queso = preguntarOpcion(scanner, "¿Quieren Queso para quesadillas/asado?");
        boolean tortillas = preguntarOpcion(scanner, "¿Van a necesitar Tortillas?");
        boolean cebollitas = preguntarOpcion(scanner, "¿Deseas agregar Cebollitas Cambray?");
        boolean guacamole = preguntarOpcion(scanner, "¿Deseas agregar Guacamole/Aguacates?");
        boolean salsa = preguntarOpcion(scanner, "¿Deseas agregar Salsa?");
        boolean refresco = preguntarOpcion(scanner, "¿Van a tomar Refresco?");
        boolean cerveza = preguntarOpcion(scanner, "¿Van a tomar Cerveza?");
        boolean carbon = preguntarOpcion(scanner, "¿Necesitas comprar Carbón?");
        boolean hielos = preguntarOpcion(scanner, "¿Necesitas comprar Bolsas de Hielo?");

        // 3. Instanciación del objeto 'miCarneAsada' mediante la palabra clave 'new'
        CalculadoraCarneAsada miCarneAsada = new CalculadoraCarneAsada(
            personas, carne, chorizo, queso, tortillas, cebollitas, 
            guacamole, salsa, refresco, cerveza, carbon, hielos
        );

        // 4. Invocación del método para imprimir los resultados calculados
        miCarneAsada.mostrarListaCompras();

        scanner.close();
    }

    /**
     * Método auxiliar para validar y convertir la respuesta ingresada por el usuario en booleano.
     */
    private static boolean preguntarOpcion(Scanner sc, String pregunta) {
        System.out.print(pregunta + " (s/n): ");
        String respuesta = sc.next().trim().toLowerCase();
        return respuesta.startsWith("s");
    }
}
