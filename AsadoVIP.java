import java.util.Arrays;

/**
 * Subclase Derivada: AsadoVIP (Versión 2)
 * Materia: Programación Orientada a Objetos - Actividad 3
 * 
 * CONCEPTOS DE POO DEMOSTRADOS:
 * 1. Herencia: Utiliza la palabra clave 'extends CalculadoraCarneAsada'.
 * 2. Reutilización de Código: Invoca el constructor padre con 'super(...)'.
 * 3. Sobrescritura de Métodos (@Override): Redefine el cálculo de carne (500g p/p de corte fino) 
 *    y la visualización del resumen de compras.
 * 4. Miembros Únicos: Soporta selección múltiple de hasta 3 tipos de cortes finos 
 *    (Ribeye, Tomahawk, T-Bone, Picanha, New York Strip, Cowboy Steak), servicio de meseros 
 *    y cálculo de tarifa por hora.
 */
public class AsadoVIP extends CalculadoraCarneAsada {

    // ------------------------------------------------------------------------
    // ATRIBUTOS EXCLUSIVOS DE LA SUBCLASE AsadoVIP
    // ------------------------------------------------------------------------
    private String[] tiposCortesFinos; // Arreglo para almacenar hasta 3 cortes seleccionados
    private boolean incluyeMeseros;    // Indica si se contrata servicio de meseros
    private int cantidadMeseros;       // 1 mesero por cada 10 personas
    private double costoMeseroPorHora; // Costo por hora por mesero

    // ------------------------------------------------------------------------
    // CONSTRUCTORES
    // ------------------------------------------------------------------------
    
    /**
     * Constructor principal que acepta un arreglo de cortes finos.
     */
    public AsadoVIP(int numeroAsistentes, boolean quiereCarne, boolean quiereChorizo, 
                    boolean quiereQueso, boolean quiereTortillas, boolean quiereCebollitas, 
                    boolean quiereGuacamole, boolean quiereSalsa, boolean quiereRefresco, 
                    boolean quiereCerveza, boolean quiereCarbon, boolean quiereHielos,
                    String[] tiposCortesFinos, boolean incluyeMeseros, int cantidadMeseros, double costoMeseroPorHora) {
        
        // Llamada al constructor de la clase base (CalculadoraCarneAsada)
        super(numeroAsistentes, quiereCarne, quiereChorizo, quiereQueso, quiereTortillas, 
              quiereCebollitas, quiereGuacamole, quiereSalsa, quiereRefresco, 
              quiereCerveza, quiereCarbon, quiereHielos);
        
        // Inicialización de los atributos propios de AsadoVIP
        this.tiposCortesFinos = tiposCortesFinos;
        this.incluyeMeseros = incluyeMeseros;
        this.costoMeseroPorHora = costoMeseroPorHora;
        this.cantidadMeseros = incluyeMeseros ? (int) Math.ceil((double) numeroAsistentes / 10.0) : 0;
    }

    /**
     * Constructor secundario de conveniencia que acepta un solo String con un corte.
     */
    public AsadoVIP(int numeroAsistentes, boolean quiereCarne, boolean quiereChorizo, 
                    boolean quiereQueso, boolean quiereTortillas, boolean quiereCebollitas, 
                    boolean quiereGuacamole, boolean quiereSalsa, boolean quiereRefresco, 
                    boolean quiereCerveza, boolean quiereCarbon, boolean quiereHielos,
                    String tipoCorteFino, boolean incluyeMeseros, int cantidadMeseros, double costoMeseroPorHora) {
        
        this(numeroAsistentes, quiereCarne, quiereChorizo, quiereQueso, quiereTortillas, 
             quiereCebollitas, quiereGuacamole, quiereSalsa, quiereRefresco, 
             quiereCerveza, quiereCarbon, quiereHielos, 
             new String[]{tipoCorteFino}, incluyeMeseros, cantidadMeseros, costoMeseroPorHora);
    }

    // ------------------------------------------------------------------------
    // SOBREESCRITURA DE MÉTODOS (@Override)
    // ------------------------------------------------------------------------

    /**
     * @Override: En un evento VIP la porción por persona es de 500g (0.50 kg) de corte fino.
     */
    @Override
    public double calcularCarne() {
        return quiereCarne ? (this.numeroAsistentes * 0.500) : 0.0;
    }

    /**
     * @Override: Extiende el método de impresión de la clase base agregando 
     * el desglose exclusivo del servicio VIP y los cortes seleccionados.
     */
    @Override
    public void mostrarListaCompras() {
        // Reutilizamos la impresión de insumos base llamando a super.mostrarListaCompras()
        super.mostrarListaCompras();

        // Imprimimos el bloque exclusivo del paquete VIP
        System.out.println("\n⭐ DETALLES DE LA EXPERIENCIA VIP ⭐");
        System.out.print("• Cortes Finos Seleccionados (" + (tiposCortesFinos != null ? tiposCortesFinos.length : 0) + "): ");
        if (tiposCortesFinos != null && tiposCortesFinos.length > 0) {
            System.out.println(String.join(", ", tiposCortesFinos));
        } else {
            System.out.println("Corte Estándar VIP");
        }
        
        System.out.println("• Kilos de Corte Fino VIP    : " + String.format("%.2f", calcularCarne()) + " kg (500g p/p)");
        
        if (incluyeMeseros) {
            System.out.println("• Personal de Meseros        : " + this.cantidadMeseros + " mesero(s) (1 por cada 10 invitados)");
            System.out.println("• Tarifa por Mesero/Hora     : $" + String.format("%.2f", this.costoMeseroPorHora));
            System.out.println("• Costo Servicio (5 horas)   : $" + String.format("%.2f", calcularCostoServicioVIP(5)));
        } else {
            System.out.println("• Servicio de Meseros        : No requerido");
        }
        System.out.println("==========================================");
    }

    // ------------------------------------------------------------------------
    // MÉTODOS EXCLUSIVOS DE LA SUBCLASE AsadoVIP
    // ------------------------------------------------------------------------

    /**
     * Método propio de AsadoVIP para calcular el costo total del servicio de meseros por horas.
     */
    public double calcularCostoServicioVIP(int horasEvento) {
        if (!incluyeMeseros) {
            return 0.0;
        }
        return this.cantidadMeseros * this.costoMeseroPorHora * horasEvento;
    }

    // Getters exclusivos
    public String[] getTiposCortesFinos() {
        return tiposCortesFinos;
    }

    public int getCantidadMeseros() {
        return cantidadMeseros;
    }

    public double getCostoMeseroPorHora() {
        return costoMeseroPorHora;
    }
}
