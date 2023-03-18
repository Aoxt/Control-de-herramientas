
class Catalogo {
    // Atributos, en este caso arreglos de objetos
    private Trabajador[] trabajadores = new Trabajador[5];
    private Herramienta[] herramientas = new Herramienta[5];
    private Prestamo[] prestamos = new Prestamo[5];
    int contT=1;
    int contH=1;
    int contPrestamos=1;

    // Método para agregar un nuevo objeto Trabajador al arreglo trabajadores
    /*
     * Explicación de como funcionan unos elemtntos del codigo
     * La comparación con null se realiza para verificar si una posición en el
     * arreglo está vacía o no ocupada por un objeto.
     * 
     * En Java, cuando declaras un arreglo de objetos (en este caso, un arreglo de
     * objetos Trabajador), cada posición en el arreglo
     * se inicializa con un valor null por defecto. Esto significa que, antes de
     * asignarle un objeto a una posición en el arreglo,
     * el valor de esa posición es null.
     * 
     * Al comparar trabajadores[i] == null, estamos verificando si la posición i en
     * el arreglo trabajadores está vacía
     * (es decir, no contiene un objeto Trabajador). Si la posición está vacía,
     * podemos asignarle el objeto Trabajador recibido como
     * parámetro en el método agregarTrabajador.
     * 
     * Cuando utilizas un bucle for-each con dos puntos (:), se recorrerán todos los
     * elementos en el arreglo,
     * incluidos aquellos que tienen el valor null. El bucle for-each no distingue
     * entre elementos vacíos o no vacíos en el arreglo.
     * 
     * El bucle for-each se utiliza principalmente para simplificar la iteración
     * sobre todos los elementos de un arreglo ,
     * 
     */
    public void agregarTrabajador(Trabajador trabajador) {
        
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i] == null) {
                trabajadores[i] = trabajador;
                contT++;
                break;
            }
        }
    }

    // Método para buscar un objeto Trabajador en el arreglo trabajadores por su ID
    public Trabajador buscarTrabajador(int id) {
        //Este es un bucle for-each
        for (Trabajador t : trabajadores) {
            if (t != null && t.getIdTrabajador() == id) {
                return t;
            }
        }
        return null;
    }

    // Método para agregar un nuevo objeto Herramienta al arreglo herramientas
    public void agregarHerramienta(Herramienta herramienta) {
        for (int i = 0; i < herramientas.length; i++) {
            if (herramientas[i] == null) {
                herramientas[i] = herramienta;
                contH++;
                break;
            }
        }
    }

    // Método para buscar un objeto Herramienta en el arreglo herramientas por su ID
    public Herramienta buscarHerramienta(int id) {
        for (Herramienta h : herramientas) {
            if (h != null && h.getIdHerramienta() == id) {
                return h;
            }
        }
        return null;
    }

    // Método para agregar un nuevo objeto Prestamo al arreglo prestamos
    public int getContT(){
        return contT;
    }
    public int getContH(){
        return contH;
    }
    public int getContP(){
        return contPrestamos;
    }
    public void agregarPrestamo(Prestamo prestamo) {
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] == null) {
                prestamos[i] = prestamo;
                contPrestamos++;
                break;
            }
        }
    }

    // Método para buscar un objeto Prestamo en el arreglo prestamos por su número
    // de préstamo
    public Prestamo buscarPrestamo(int numPrestamo) {
        for (Prestamo p : prestamos) {
            if (p != null && p.getNumPrestamo() == numPrestamo) {
                return p;
            }
        }
        return null;
    }

    // Métodos getter que devuelven los arreglos de objetos correspondientes
    public Trabajador[] getTrabajadores() {
        return trabajadores;
    }

    public Herramienta[] getHerramientas() {
        return herramientas;
    }

    public Prestamo[] getPrestamos() {
        return prestamos;
    }
}