import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase Principal: Main (Versión 6 - Corregido buffer de lectura)
 * Actividad 3: Herencia en Programación Orientada a Objetos (POO)
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n==================================================");
            System.out.println("🔥 ORGANIZADOR DE CARNE ASADA (ACTIVIDAD 3 - POO) 🔥");
            System.out.println("==================================================");
            System.out.println("Selecciona el tipo de evento que deseas cotizar:");
            System.out.println("1. Carne Asada Estándar (Clase Base: CalculadoraCarneAsada)");
            System.out.println("2. Carne Asada VIP (Subclase: AsadoVIP)");
            System.out.println("3. Carne Asada Empresarial (Subclase: AsadoEmpresarial)");
            System.out.println("0. Salir");
            System.out.print("Ingresa tu opción (0-3): ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpia el salto de línea del menú
            } else {
                System.out.println("Opción inválida. Intenta nuevamente.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    configurarAsadoEstandar(scanner);
                    break;
                case 2:
                    configurarAsadoVIP(scanner);
                    break;
                case 3:
                    configurarAsadoEmpresarial(scanner);
                    break;
                case 0:
                    System.out.println("\n¡Gracias por utilizar el Organizador de Carne Asada! ¡Hasta luego! 🥩🔥");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor selecciona entre 0 y 3.");
            }
        }

        scanner.close();
    }

    private static void configurarAsadoEstandar(Scanner scanner) {
        System.out.println("\n--- 🥩 CONFIGURACIÓN DE CARNE ASADA ESTÁNDAR ---");
        System.out.print("¿Cuántas personas van a asistir? ");
        int personas = scanner.nextInt();

        boolean carne = preguntarOpcion(scanner, "¿Van a comer Carne de Res?");
        boolean chorizo = preguntarOpcion(scanner, "¿Van a comer Chorizo?");
        boolean queso = preguntarOpcion(scanner, "¿Quieren Queso para quesadillas?");
        boolean tortillas = preguntarOpcion(scanner, "¿Van a necesitar Tortillas?");
        boolean cebollitas = preguntarOpcion(scanner, "¿Deseas agregar Cebollitas Cambray?");
        boolean guacamole = preguntarOpcion(scanner, "¿Deseas agregar Guacamole/Aguacates?");
        boolean salsa = preguntarOpcion(scanner, "¿Deseas agregar Salsa?");
        boolean refresco = preguntarOpcion(scanner, "¿Van a tomar Refresco?");
        boolean cerveza = preguntarOpcion(scanner, "¿Van a tomar Cerveza?");
        boolean carbon = preguntarOpcion(scanner, "¿Necesitas comprar Carbón?");
        boolean hielos = preguntarOpcion(scanner, "¿Necesitas comprar Bolsas de Hielo?");

        CalculadoraCarneAsada estandar = new CalculadoraCarneAsada(
            personas, carne, chorizo, queso, tortillas, cebollitas,
            guacamole, salsa, refresco, cerveza, carbon, hielos
        );

        estandar.mostrarListaCompras();
    }

    private static void configurarAsadoVIP(Scanner scanner) {
        System.out.println("\n--- 👑 CONFIGURACIÓN DE CARNE ASADA VIP ---");
        System.out.print("¿Cuántas personas van a asistir? ");
        int personas = scanner.nextInt();
        scanner.nextLine();

        String[] menuCortes = {
            "Ribeye Premium",
            "Tomahawk",
            "T-Bone",
            "Picanha",
            "New York Strip",
            "Cowboy Steak"
        };

        System.out.println("\n--- 🥩 MENÚ DE CORTES FINOS DISPONIBLES ---");
        System.out.println("Puedes elegir hasta 3 cortes distintos para tu evento:");
        for (int i = 0; i < menuCortes.length; i++) {
            System.out.println("  " + (i + 1) + ". " + menuCortes[i]);
        }

        List<String> cortesElegidos = new ArrayList<>();
        System.out.println("\nSelecciona hasta 3 opciones (o ingresa 0 para terminar):");

        for (int i = 1; i <= 3; i++) {
            System.out.print("Selecciona corte #" + i + " (1-6 o 0 para finalizar): ");
            if (scanner.hasNextInt()) {
                int sel = scanner.nextInt();
                if (sel == 0) {
                    break;
                }
                if (sel >= 1 && sel <= menuCortes.length) {
                    String corteSeleccionado = menuCortes[sel - 1];
                    if (!cortesElegidos.contains(corteSeleccionado)) {
                        cortesElegidos.add(corteSeleccionado);
                        System.out.println("   -> Agregado: " + corteSeleccionado);
                    } else {
                        System.out.println("   -> Ya habías seleccionado ese corte.");
                        i--;
                    }
                } else {
                    System.out.println("   -> Opción fuera de rango.");
                    i--;
                }
            } else {
                System.out.println("   -> Entrada no válida.");
                scanner.next();
                i--;
            }
        }

        if (cortesElegidos.isEmpty()) {
            cortesElegidos.add("Ribeye Premium");
            System.out.println("   -> Se asignó por defecto: Ribeye Premium");
        }

        String[] cortesArray = cortesElegidos.toArray(new String[0]);

        boolean incluirMeseros = preguntarOpcion(scanner, "¿Deseas incluir servicio de meseros?");
        int numMeseros = 0;
        if (incluirMeseros) {
            numMeseros = (int) Math.ceil(personas / 10.0);
            System.out.println("-> Se asignarán automáticamente " + numMeseros + " mesero(s).");
        }

        boolean carne = true;
        boolean chorizo = preguntarOpcion(scanner, "¿Van a comer Chorizo artesanal?");
        boolean queso = preguntarOpcion(scanner, "¿Quieren Queso gourmet para asar?");
        boolean tortillas = preguntarOpcion(scanner, "¿Van a necesitar Tortillas de harina/maíz?");
        boolean cebollitas = preguntarOpcion(scanner, "¿Deseas agregar Cebollitas Cambray?");
        boolean guacamole = preguntarOpcion(scanner, "¿Deseas agregar Guacamole preparado?");
        boolean salsa = preguntarOpcion(scanner, "¿Deseas agregar Salsas artesanales?");
        boolean refresco = preguntarOpcion(scanner, "¿Van a tomar Refresco?");
        boolean cerveza = preguntarOpcion(scanner, "¿Van a tomar Cerveza artesanal?");
        boolean carbon = preguntarOpcion(scanner, "¿Necesitas Carbón de encino?");
        boolean hielos = preguntarOpcion(scanner, "¿Necesitas Bolsas de Hielo?");

        AsadoVIP vip = new AsadoVIP(
            personas, carne, chorizo, queso, tortillas, cebollitas,
            guacamole, salsa, refresco, cerveza, carbon, hielos,
            cortesArray, incluirMeseros, numMeseros, 250.0
        );

        vip.mostrarListaCompras();

        if (incluirMeseros) {
            System.out.print("¿Cuántas horas durará el evento? ");
            int horas = scanner.nextInt();
            double costoTotalMeseros = vip.calcularCostoServicioVIP(horas);
            System.out.println("💰 Costo total por servicio de meseros (" + horas + " horas): $" + String.format("%.2f", costoTotalMeseros) + " MXN");
        }
    }

    private static void configurarAsadoEmpresarial(Scanner scanner) {
        System.out.println("\n--- 🏢 CONFIGURACIÓN DE CARNE ASADA EMPRESARIAL ---");
        // Se removió el scanner.nextLine() duplicado que causaba pedir un ENTER extra
        System.out.print("Nombre de la Empresa o Razón Social: ");
        String empresa = scanner.nextLine();

        System.out.print("Área / Departamento organizador: ");
        String departamento = scanner.nextLine();

        System.out.print("Nombre del Responsable del Evento: ");
        String responsable = scanner.nextLine();

        System.out.print("¿Cuántos colaboradores asistirán? ");
        int personas = scanner.nextInt();

        boolean carne = preguntarOpcion(scanner, "¿Van a incluir Carne de Res?");
        boolean chorizo = preguntarOpcion(scanner, "¿Van a incluir Chorizo?");
        boolean queso = preguntarOpcion(scanner, "¿Van a incluir Queso?");
        boolean tortillas = preguntarOpcion(scanner, "¿Van a incluir Tortillas?");
        boolean cebollitas = preguntarOpcion(scanner, "¿Van a incluir Cebollitas?");
        boolean guacamole = preguntarOpcion(scanner, "¿Van a incluir Guacamole?");
        boolean salsa = preguntarOpcion(scanner, "¿Van a incluir Salsa?");
        boolean refresco = preguntarOpcion(scanner, "¿Van a incluir Refrescos?");
        boolean cerveza = preguntarOpcion(scanner, "¿Van a incluir Cervezas?");
        boolean carbon = preguntarOpcion(scanner, "¿Van a incluir Carbón?");
        boolean hielos = preguntarOpcion(scanner, "¿Van a incluir Hielos?");

        AsadoEmpresarial corp = new AsadoEmpresarial(
            personas, carne, chorizo, queso, tortillas, cebollitas,
            guacamole, salsa, refresco, cerveza, carbon, hielos,
            empresa, departamento, responsable
        );

        corp.mostrarListaCompras();
        corp.mostrarFichaControlInterno();
    }

    private static boolean preguntarOpcion(Scanner sc, String pregunta) {
        System.out.print(pregunta + " (s/n): ");
        String respuesta = sc.next().trim().toLowerCase();
        return respuesta.startsWith("s");
    }
}
