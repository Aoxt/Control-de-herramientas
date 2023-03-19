
// Clase Prestamo
public class Prestamo {
    // Atributos 
    private int numPrestamo;
    private int idTrabajador;
    private int idHerramienta;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private char estado;

    // Constructor 
    public Prestamo(int numPrestamo, int idTrabajador, int idHerramienta, String fechaPrestamo, String fechaDevolucion, char estado) {
        this.numPrestamo = numPrestamo;
        this.idTrabajador = idTrabajador;
        this.idHerramienta = idHerramienta;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

    // Metodos get
    public int getNumPrestamo() {
        return numPrestamo;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public int getIdHerramienta() {
        return idHerramienta;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }
    public char getEstado() {
        return estado;
    }
    
    // Metodos set
    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    // Metodo toString, esto devuelve una impresion de los atrubutos que tienen las instancias de esta clase.
    public String toString() {
        return "\nNumero de Prestamo: " + numPrestamo;
    }
}
