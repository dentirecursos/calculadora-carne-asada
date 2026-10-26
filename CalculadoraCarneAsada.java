/**
 * Clase: CalculadoraCarneAsada
 * Propósito: Modela una reunión de carne asada permitiendo activar o desactivar
 * de forma independiente cada alimento, bebida e insumo de la lista, calculando
 * las cantidades exactas necesarias según el número de asistentes.
 */
public class CalculadoraCarneAsada {

    // ------------------------------------------------------------------------
    // ATRIBUTOS PRIVADOS (Principio de Encapsulamiento)
    // ------------------------------------------------------------------------
    private int numeroAsistentes;
    private boolean quiereCarne;
    private boolean quiereChorizo;
    private boolean quiereQueso;
    private boolean quiereTortillas;
    private boolean quiereCebollitas;
    private boolean quiereGuacamole;
    private boolean quiereSalsa;
    private boolean quiereRefresco;
    private boolean quiereCerveza;
    private boolean quiereCarbon;
    private boolean quiereHielos;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR (Inicializa la instancia con las preferencias seleccionadas)
    // ------------------------------------------------------------------------
    /**
     * Constructor completo de la clase CalculadoraCarneAsada.
     */
    public CalculadoraCarneAsada(int numeroAsistentes, boolean quiereCarne, 
                                boolean quiereChorizo, boolean quiereQueso, 
                                boolean quiereTortillas, boolean quiereCebollitas, 
                                boolean quiereGuacamole, boolean quiereSalsa, 
                                boolean quiereRefresco, boolean quiereCerveza, 
                                boolean quiereCarbon, boolean quiereHielos) {
        this.numeroAsistentes = numeroAsistentes;
        this.quiereCarne = quiereCarne;
        this.quiereChorizo = quiereChorizo;
        this.quiereQueso = quiereQueso;
        this.quiereTortillas = quiereTortillas;
        this.quiereCebollitas = quiereCebollitas;
        this.quiereGuacamole = quiereGuacamole;
        this.quiereSalsa = quiereSalsa;
        this.quiereRefresco = quiereRefresco;
        this.quiereCerveza = quiereCerveza;
        this.quiereCarbon = quiereCarbon;
        this.quiereHielos = quiereHielos;
    }

    // ------------------------------------------------------------------------
    // MÉTODOS DE CÁLCULO (Lógica del Negocio)
    // ------------------------------------------------------------------------

    /** Calcula kilos de carne de res (350g por persona) */
    public double calcularCarne() {
        return quiereCarne ? (this.numeroAsistentes * 0.350) : 0.0;
    }

    /** Calcula kilos de chorizo (150g por persona) */
    public double calcularChorizo() {
        return quiereChorizo ? (this.numeroAsistentes * 0.150) : 0.0;
    }

    /** Calcula kilos de queso para asar (100g por persona) */
    public double calcularQueso() {
        return quiereQueso ? (this.numeroAsistentes * 0.100) : 0.0;
    }

    /** Calcula kilos de tortillas (150g por persona) */
    public double calcularKilosTortillas() {
        return quiereTortillas ? (this.numeroAsistentes * 0.150) : 0.0;
    }

    /** Calcula piezas de cebollitas cambray (3 piezas por persona) */
    public int calcularPiezasCebollitas() {
        return quiereCebollitas ? (this.numeroAsistentes * 3) : 0;
    }

    /** Calcula piezas de aguacates para guacamole (1 aguacate por cada 3 personas) */
    public int calcularPiezasAguacates() {
        return quiereGuacamole ? (int) Math.ceil((double) this.numeroAsistentes / 3.0) : 0;
    }

    /** Calcula litros de salsa (100 ml por persona) */
    public double calcularSalsa() {
        return quiereSalsa ? (this.numeroAsistentes * 0.100) : 0.0;
    }

    /** Calcula litros de refresco (0.5 Litros por persona) */
    public double calcularRefresco() {
        return quiereRefresco ? (this.numeroAsistentes * 0.500) : 0.0;
    }

    /** Calcula latas de cerveza (4 latas por persona) */
    public int calcularCerveza() {
        return quiereCerveza ? (this.numeroAsistentes * 4) : 0;
    }

    /** Calcula bolsas de carbón de 3kg (1 bolsa por cada 6 personas) */
    public int calcularCarbon() {
        return quiereCarbon ? (int) Math.ceil((double) this.numeroAsistentes / 6.0) : 0;
    }

    /** Calcula bolsas de hielo (1 bolsa por cada 6 personas) */
    public int calcularHielos() {
        return quiereHielos ? (int) Math.ceil((double) this.numeroAsistentes / 6.0) : 0;
    }

    // ------------------------------------------------------------------------
    // MÉTODOS DE SALIDA / IMPRESIÓN
    // ------------------------------------------------------------------------

    /**
     * Muestra en pantalla la lista de compras final únicamente con los ítems seleccionados.
     */
    public void mostrarListaCompras() {
        System.out.println("\n==========================================");
        System.out.println("   TU LISTA DE COMPRAS PERSONALIZADA     ");
        System.out.println("==========================================");
        System.out.println("Asistentes confirmados: " + this.numeroAsistentes + " personas\n");

        System.out.println("--- INSUMOS A COMPRAR ---");

        if (quiereCarne) {
            System.out.println("• Carne de Res        : " + String.format("%.2f", calcularCarne()) + " kg");
        }
        if (quiereChorizo) {
            System.out.println("• Chorizo / Longaniza : " + String.format("%.2f", calcularChorizo()) + " kg");
        }
        if (quiereQueso) {
            System.out.println("• Queso para asar     : " + String.format("%.2f", calcularQueso()) + " kg");
        }
        if (quiereTortillas) {
            System.out.println("• Tortillas           : " + String.format("%.2f", calcularKilosTortillas()) + " kg");
        }
        if (quiereCebollitas) {
            System.out.println("• Cebollitas Cambray  : " + calcularPiezasCebollitas() + " piezas");
        }
        if (quiereGuacamole) {
            System.out.println("• Aguacates           : " + calcularPiezasAguacates() + " piezas");
        }
        if (quiereSalsa) {
            System.out.println("• Salsa               : " + String.format("%.2f", calcularSalsa()) + " Litros");
        }
        if (quiereRefresco) {
            System.out.println("• Refrescos           : " + String.format("%.1f", calcularRefresco()) + " Litros (aprox. " + 
                               (int) Math.ceil(calcularRefresco() / 2.5) + " botella(s) de 2.5L)");
        }
        if (quiereCerveza) {
            System.out.println("• Cervezas            : " + calcularCerveza() + " latas (" + 
                               (int) Math.ceil(calcularCerveza() / 6.0) + " Six-Packs)");
        }
        if (quiereCarbon) {
            System.out.println("• Carbón              : " + calcularCarbon() + " bolsa(s) de 3kg");
        }
        if (quiereHielos) {
            System.out.println("• Bolsas de Hielo     : " + calcularHielos() + " bolsa(s)");
        }

        System.out.println("==========================================\n");
    }
}
