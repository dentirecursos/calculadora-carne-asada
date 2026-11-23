/**
 * Subclase Derivada: AsadoEmpresarial
 * Materia: Programación Orientada a Objetos - Actividad 3
 * 
 * CONCEPTOS DE POO DEMOSTRADOS:
 * 1. Herencia: Extiende la clase base 'CalculadoraCarneAsada'.
 * 2. Reutilización de Código: Aprovecha atributos y métodos heredados mediante 'super'.
 * 3. Sobrescritura de Métodos (@Override): Personaliza la vista del resumen agregando
 *    la información de la empresa y el área organizadora.
 * 4. Atributos y Métodos Únicos: Agrega campos como 'nombreEmpresa', 'departamento' 
 *    y 'responsableEvento'.
 */
public class AsadoEmpresarial extends CalculadoraCarneAsada {

    // ------------------------------------------------------------------------
    // ATRIBUTOS EXCLUSIVOS DE LA SUBCLASE AsadoEmpresarial
    // ------------------------------------------------------------------------
    private String nombreEmpresa;
    private String departamento;
    private String responsableEvento;

    // ------------------------------------------------------------------------
    // CONSTRUCTOR (Invoca a super(...) para inicializar la clase base)
    // ------------------------------------------------------------------------
    public AsadoEmpresarial(int numeroAsistentes, boolean quiereCarne, boolean quiereChorizo, 
                            boolean quiereQueso, boolean quiereTortillas, boolean quiereCebollitas, 
                            boolean quiereGuacamole, boolean quiereSalsa, boolean quiereRefresco, 
                            boolean quiereCerveza, boolean quiereCarbon, boolean quiereHielos,
                            String nombreEmpresa, String departamento, String responsableEvento) {
        
        // Inicializa los miembros heredados de la clase base
        super(numeroAsistentes, quiereCarne, quiereChorizo, quiereQueso, quiereTortillas, 
              quiereCebollitas, quiereGuacamole, quiereSalsa, quiereRefresco, 
              quiereCerveza, quiereCarbon, quiereHielos);
        
        this.nombreEmpresa = nombreEmpresa;
        this.departamento = departamento;
        this.responsableEvento = responsableEvento;
    }

    // Constructor simplificado (por si no se especifica responsable)
    public AsadoEmpresarial(int numeroAsistentes, boolean quiereCarne, boolean quiereChorizo, 
                            boolean quiereQueso, boolean quiereTortillas, boolean quiereCebollitas, 
                            boolean quiereGuacamole, boolean quiereSalsa, boolean quiereRefresco, 
                            boolean quiereCerveza, boolean quiereCarbon, boolean quiereHielos,
                            String nombreEmpresa, String departamento) {
        
        this(numeroAsistentes, quiereCarne, quiereChorizo, quiereQueso, quiereTortillas, 
             quiereCebollitas, quiereGuacamole, quiereSalsa, quiereRefresco, 
             quiereCerveza, quiereCarbon, quiereHielos, nombreEmpresa, departamento, "No especificado");
    }

    // ------------------------------------------------------------------------
    // SOBREESCRITURA DE MÉTODOS (@Override)
    // ------------------------------------------------------------------------

    /**
     * @Override: Redefine la salida para presentar un reporte interno del evento corporativo.
     */
    @Override
    public void mostrarListaCompras() {
        System.out.println("\n==========================================");
        System.out.println("   REPORTE DE EVENTO EMPRESARIAL          ");
        System.out.println("==========================================");
        System.out.println("• Empresa Organizadora : " + this.nombreEmpresa);
        System.out.println("• Área / Departamento  : " + this.departamento);
        System.out.println("• Responsable Evento   : " + this.responsableEvento);
        System.out.println("• Asistentes Totales   : " + this.numeroAsistentes + " colaboradores");
        
        // Invocamos el método de la clase base para listar los insumos
        super.mostrarListaCompras();
    }

    // ------------------------------------------------------------------------
    // MÉTODOS EXCLUSIVOS DE LA SUBCLASE AsadoEmpresarial
    // ------------------------------------------------------------------------

    /**
     * Método propio para imprimir la ficha de control interno del departamento.
     */
    public void mostrarFichaControlInterno() {
        System.out.println("\n📋 FICHA DE CONTROL INTERNO");
        System.out.println("• Empresa: " + this.nombreEmpresa);
        System.out.println("• Centro/Depto: " + this.departamento);
        System.out.println("• Encargado: " + this.responsableEvento);
        System.out.println("• Total Invitados: " + this.numeroAsistentes + " personas");
        System.out.println("==========================================\n");
    }

    // Getters exclusivos
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getResponsableEvento() {
        return responsableEvento;
    }
}
