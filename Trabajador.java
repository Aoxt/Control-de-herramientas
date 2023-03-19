public class Trabajador {
    private int idTrabajador;
    private String nombre;
    private String puesto;

    // Constructor de la clase Trabajador
    public Trabajador(int idTrabajador, String nombre, String puesto) {
        this.idTrabajador = idTrabajador;
        this.nombre = nombre;
        this.puesto = puesto;
    }

    // Metodos Get
    public int getIdTrabajador() {
        return idTrabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    // Metodo que ayuda a imprimir los datos de las instancias de una clase, en este
    // caso trabajador.
    public String toString() {
        return "\nDatos del trabajador\n" +
                "Id del trabajador----: " + idTrabajador + "\n"+
                "Nombre del trabajador: " + nombre + "\n"+
                "Puesto del trabajador: " + puesto + "\n";
    }
}