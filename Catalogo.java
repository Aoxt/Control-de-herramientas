class Catalogo {
    // Atributos, en este caso arreglos de objetos
    private Trabajador[] trabajadores = new Trabajador[110];
    private Herramienta[] herramientas = new Herramienta[250];
    private Prestamo[] prestamos = new Prestamo[500];
    int contT=1;
    int contH=1;
    int contPrestamos=1;
    int contConcluidos=0;
    int contActivos=0;

    // Metodo para agregar un nuevo objeto Trabajador al arreglo trabajadores
    /*
     * Explicaci�n de como funcionan unos elemtntos del codigo
     * La comparaci�n con null se realiza para verificar si una posici�n en el
     * arreglo está vacía o no ocupada por un objeto.
     * 
     * En Java, cuando declaras un arreglo de objetos (en este caso, un arreglo de
     * objetos Trabajador), cada posici�n en el arreglo
     * se inicializa con un valor null por defecto. Esto significa que, antes de
     * asignarle un objeto a una posici�n en el arreglo,
     * el valor de esa posici�n es null.
     * 
     * Al comparar trabajadores[i] == null, estamos verificando si la posici�n i en
     * el arreglo trabajadores esta vacia
     * (es decir, no contiene un objeto Trabajador). Si la posici�n esta vacia,
     * podemos asignarle el objeto Trabajador recibido como
     * parametro en el metodo agregarTrabajador.
     * 
     * Cuando utilizas un bucle for-each con dos puntos (:), se recorreran todos los
     * elementos en el arreglo,
     * incluidos aquellos que tienen el valor null. El bucle for-each no distingue
     * entre elementos vacios o no vacios en el arreglo.
     * 
     * El bucle for-each se utiliza principalmente para simplificar la iteraci�n
     * sobre todos los elementos de un arreglo ,
     * 
     */
    public void agregarTrabajador(Trabajador trabajador) {
        //Este es un bucle for-each
        for (int i = 0; i < trabajadores.length; i++) {
            if (trabajadores[i] == null) {
                trabajadores[i] = trabajador;
                contT++;
                break;
            }
        }
    }

    // Metodo para buscar un objeto Trabajador en el arreglo trabajadores por su ID
    public Trabajador buscarTrabajador(int id) {
        for (Trabajador t : trabajadores) {
            if (t != null && t.getIdTrabajador() == id) {
                return t;
            }
        }
        return null;
    }

    // Metodo para agregar un nuevo objeto Herramienta al arreglo herramientas
    public void agregarHerramienta(Herramienta herramienta) {
        for (int i = 0; i < herramientas.length; i++) {
            if (herramientas[i] == null) {
                herramientas[i] = herramienta;
                contH++;
                break;
            }
        }
    }

    // Metodo para buscar un objeto Herramienta en el arreglo herramientas por su ID
    public Herramienta buscarHerramienta(int id) {
        for (Herramienta h : herramientas) {
            if (h != null && h.getIdHerramienta() == id) {
                return h;
            }
        }
        return null;
    }

    
    public int getContT(){
        return contT;
    }
    public int getContH(){
        return contH;
    }
    public int getContP(){
        return contPrestamos;
    }
    public int getContConcluidos(){
        return contConcluidos;
    }
    public int getContActivos(){
        return contActivos;
    }
    // Metodo para agregar un nuevo objeto Prestamo al arreglo prestamos
    public void agregarPrestamo(Prestamo prestamo) {
        for (int i = 0; i < prestamos.length; i++) {
            if (prestamos[i] == null) {
                prestamos[i] = prestamo;
                contPrestamos++;
                break;
            }
        }
    }

    // Metodo para buscar un objeto Prestamo en el arreglo prestamos por su numero
    // de prestamo
    public Prestamo buscarPrestamo(int numPrestamo) {
        for (Prestamo p : prestamos) {
            if (p != null && p.getNumPrestamo() == numPrestamo) {
                return p;
            }
        }
        return null;
    }

    // Metodos getter que devuelven los arreglos de objetos correspondientes
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