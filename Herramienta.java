public class Herramienta {
    private int idHerramienta;
    private String nombre;
    private String marca;
    private char estado;

    // Constructor de la clase Herramienta
    public Herramienta(int idHerramienta, String nombre, String marca, char estado) {
        this.idHerramienta = idHerramienta;
        this.nombre = nombre;
        this.marca = marca;
        this.estado = estado;
    }

    // Metodos Get
    public int getIdHerramienta() {
        return idHerramienta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMarca() {
        return marca;
    }

    public char getEstado() {
        return estado;
    }

    // Metodo Setter
    public void setEstado(char estado) {
        this.estado = estado;
    }

    // Metodo que ayuda a imprimir los datos de las instancias de una clase, en este
    // caso Herramienta

    public String toString() {
        return "\nDatos de la herramienta\n" +
        "ID----: " + idHerramienta + "\n"+
        "Nombre: " + nombre + "\n"+
        "Marca-: " + marca + "\n"+
        "Estado: " + (estado == 'P' ? "Prestada" : "Disponible");
        }
    /*
     * Esta expresion se lee como "si estado es igual a 'P', imprime "Prestada",de
     * lo contrario,imprime "Disponible".
     * El signo de interrogacion ? y los dos puntos : en este contexto se utilizan
     * como parte de la expresion condicional
     * (tambien llamada operador ternario) en Java. La expresion condicional es una
     * forma abreviada de una instruccion
     * if-else que permite asignar un valor a una variable o expresion en funcion de
     * una condicion booleana. La sintaxis
     * general de la expresion condicional es:
     * condicion ? valor_si_verdadero : valor_si_falso

     */
}
