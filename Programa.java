import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Programa {
    // Esta cosa le da un formato a la fecha que espera en la lectura de las fechas.
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String args[]) {
        Scanner leer = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();
        int opcion;
        // MENU PRINCIPAL
        do {
            System.out.println("HORNOS MEXICANOS");
            System.out.println("[1] Catalogo de trabajadores");
            System.out.println("[2] Catalogo de herramientas");
            System.out.println("[3] Control de prestamos de herramientas");
            System.out.println("[4] Finalizar programa");
            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    menuTrabajadores(leer, catalogo);
                    break;
                case 2:
                    menuHerramientas(leer, catalogo);
                    break;
                case 3:
                    menuPrestamos(leer, catalogo);
                    break;
                case 4:
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);
    }

    // MENU TRABAJADORES
    private static void menuTrabajadores(Scanner leer, Catalogo catalogo) {
        int opcion;

        do {
            System.out.println("\nHORNOS MEXICANOS - CATALOGO DE TRABAJADORES");
            System.out.println("[1] Alta de un trabajador");
            System.out.println("[2] Consulta de un trabajador");
            System.out.println("[3] Consulta de todos los trabajadores");
            System.out.println("[4] Regresar al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    altaTrabajador(leer, catalogo);
                    break;
                case 2:

                    if (catalogo.getContT() - 1 > 0) {
                        consultaTrabajador(leer, catalogo);
                    } else {
                        System.out.println("Aun no hay registros de trabajadores");
                    }
                    break;
                case 3:
                    if (catalogo.getContT() - 1 > 0) {
                        consultaTodosTrabajadores(catalogo);
                    } else {
                        System.out.println("Aun no hay registros de trabajadores");
                    }

                    break;
                case 4:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);
    }

    private static void altaTrabajador(Scanner leer, Catalogo catalogo) {
        System.out.print("Ingrese el ID del trabajador: ");
        int idTrabajador = leer.nextInt();
        leer.nextLine(); // Consumir el salto de línea

        if (catalogo.buscarTrabajador(idTrabajador) != null) {
            System.out.println("Error: Ya existe un trabajador con ese ID.");
            return;
        }

        System.out.print("Ingrese el nombre del trabajador: ");
        String nombre = leer.nextLine();
        System.out.print("Ingrese el puesto del trabajador: ");
        String puesto = leer.nextLine();

        catalogo.agregarTrabajador(new Trabajador(idTrabajador, nombre, puesto));
        System.out.println("Trabajador registrado exitosamente.");
    }

    private static void consultaTrabajador(Scanner leer, Catalogo catalogo) {
        System.out.print("Ingrese el ID del trabajador: ");
        int idTrabajador = leer.nextInt();

        Trabajador trabajador = catalogo.buscarTrabajador(idTrabajador);
        if (trabajador != null) {
            System.out.println(trabajador);
        } else {
            System.out.println("Trabajador no encontrado.");
        }
    }

    private static void consultaTodosTrabajadores(Catalogo catalogo) {
        for (Trabajador t : catalogo.getTrabajadores()) {
            if (t != null) {
                System.out.println(t);
                System.out.println("--------------------------------------");
            }
        }
    }

    // MENU HERRAMIENTAS Y MERODOS

    private static void menuHerramientas(Scanner leer, Catalogo catalogo) {
        int opcion;

        do {
            System.out.println("\nHORNOS MEXICANOS - CATALOGO DE HERRAMIENTAS");
            System.out.println("[1] Alta de una herramienta");
            System.out.println("[2] Consulta de una herramienta");
            System.out.println("[3] Consulta de todas las herramientas");
            System.out.println("[4] Regresar al menu principal");
            System.out.print("Seleccione una opcion: ");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    altaHerramienta(leer, catalogo);
                    break;
                case 2:
                    if (catalogo.getContH() - 1 > 0) {
                        consultaHerramienta(leer, catalogo);
                    } else {
                        System.out.println("Aun no hay registros de herramientas");
                    }
                    break;

                case 3:
                    if (catalogo.getContH() - 1 > 0) {
                        consultaGeneralHerramientas(catalogo);
                    } else {
                        System.out.println("Aun no hay registros de herramientas");
                    }
                    break;
                case 4:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);
    }

    private static void altaHerramienta(Scanner leer, Catalogo catalogo) {
        System.out.print("Ingrese el ID de la herramienta: ");
        int idHerramienta = leer.nextInt();
        leer.nextLine(); // Consumir el salto de línea

        if (catalogo.buscarHerramienta(idHerramienta) != null) {
            System.out.println("Error: Ya existe una herramienta con ese ID.");
            return;
        }

        System.out.print("Ingrese el nombre de la herramienta: ");
        String nombre = leer.nextLine();
        System.out.print("Ingrese la marca de la herramienta: ");
        String marca = leer.nextLine();

        catalogo.agregarHerramienta(new Herramienta(idHerramienta, nombre, marca, 'D'));
        System.out.println("Herramienta registrada exitosamente.");
    }

    private static void consultaHerramienta(Scanner leer, Catalogo catalogo) {
        System.out.print("Ingrese el ID de la herramienta: ");
        int idHerramienta = leer.nextInt();

        Herramienta herramienta = catalogo.buscarHerramienta(idHerramienta);
        if (herramienta != null) {
            System.out.println(herramienta);
        } else {
            System.out.println("Herramienta no encontrada.");
        }
    }

    private static void consultaGeneralHerramientas(Catalogo catalogo) {
        System.out.println("CONSULTA GENERAL HERRAMIENTAS ");
        for (Herramienta h : catalogo.getHerramientas()) {
            if (h != null) {
                System.out.println(h);
                System.out.println("---------------------------------");
            }
        }
    }

    // MENU PRESTAMOS Y METODOS

    private static void menuPrestamos(Scanner leer, Catalogo catalogo) {
        int opcion;
        do {
            System.out.println("\nHORNOS MEXICANOS - CONTROL DE PRESTAMOS DE HERRAMIENTAS");
            System.out.println("[1] Registrar prestamo");
            System.out.println("[2] Registrar devolucion");
            System.out.println("[3] Consultar prestamo");
            System.out.println("[4] Reporte de prestamos activos");
            System.out.println("[5] Reporte de prestamos concluidos");
            System.out.println("[6] Regresar al menu principal");
            System.out.print("Seleccione una opcion:\n");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    registrarPrestamo(leer, catalogo);
                    break;
                case 2:
                    registrarDevolucion(leer, catalogo);
                    break;
                case 3:

                    consultarPrestamo(leer, catalogo);

                    break;
                case 4:
                    reportePrestamosActivos(catalogo);

                    break;
                case 5:
                    reportePrestamosConcluidos(catalogo);
                    break;
                case 6:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion inválida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 6);
    }

    private static void registrarPrestamo(Scanner leer, Catalogo catalogo) {
        int confirmar;
        int contadorPrestamos = catalogo.getContP();
        if (catalogo.buscarPrestamo(contadorPrestamos) != null) {
            System.out.println("Error: Ya existe un prestamo con ese numero.");
            return;
        }
        System.out.printf("Numero de prestamo: %d\n", catalogo.getContP());
        System.out.print("Ingrese el id del trabajador: ");
        int idTrabajador = leer.nextInt();
        Trabajador trabajador = catalogo.buscarTrabajador(idTrabajador);
        if (trabajador == null) {
            System.out.println("Error: Trabajador no encontrado.");
            return;
        } else {
            System.out.printf("Nombre del trabajador: %s\n", trabajador.getNombre());
        }

        System.out.print("Ingrese el ID de la herramienta: ");
        int idHerramienta = leer.nextInt();
        Herramienta herramienta = catalogo.buscarHerramienta(idHerramienta);
        if (herramienta == null) {
            System.out.println("Error: Herramienta no encontrada.");
            return;
        } else {
            System.out.printf("Nombre de la herramienta: %s\n", herramienta.getNombre());
        }

        if (herramienta.getEstado() == 'P') {
            System.out.println("Error: La herramienta ya está prestada.");
            return;
        }

        System.out.print("Ingrese la fecha de prestamo (dd/MM/YYYY): ");
        String fechaPrestamo = leer.next();
        try {
            LocalDate.parse(fechaPrestamo, dtf);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Formato de fecha incorrecto.");
            return;
        }
        System.out.println("Estas seguro de registrar el prestamo? [1=Si, 2=No]");
        confirmar = leer.nextInt();
        if (confirmar == 1) {
            Prestamo prestamo = new Prestamo(contadorPrestamos, idTrabajador, idHerramienta, fechaPrestamo, null, 'A');
            catalogo.agregarPrestamo(prestamo);
            herramienta.setEstado('P');
            catalogo.contActivos++;
            System.out.println("Prestamo registrado exitosamente.");
        } else {
            System.out.println("No se realizo el registro");
        }
    }

    private static void registrarDevolucion(Scanner leer, Catalogo catalogo) {

        if (catalogo.getContP() >= 2) {
            System.out.print("Ingrese el numero de préstamo: ");
            int numPrestamo = leer.nextInt();

            Prestamo prestamo = catalogo.buscarPrestamo(numPrestamo);
            if (prestamo == null) {
                System.out.println("Error: Prestamo no encontrado.");
                return;
            }

            if (prestamo.getEstado() == 'C') {
                System.out.println("Error: El prestamo ya esta concluido.");
                return;
            }
            Trabajador trabajador = catalogo.buscarTrabajador(prestamo.getIdTrabajador());
            Herramienta herramienta = catalogo.buscarHerramienta(prestamo.getIdHerramienta());
            System.out.println("Id del Trabajador: " + trabajador.getIdTrabajador());
            System.out.printf("Nombre del trabajador: %s\n", trabajador.getNombre());
            System.out.println("Id de la Herramienta: " + herramienta.getIdHerramienta());
            System.out.printf("Nombre de la herramienta: %s\n", herramienta.getNombre());
            System.out.printf("Fecha de prestamo: %s\n", prestamo.getFechaPrestamo());
            System.out.print("Ingrese la fecha de devolucion (dd/MM/YYYY): ");
            String fechaDevolucion = leer.next();
            try {
                LocalDate fechaDev = LocalDate.parse(fechaDevolucion, dtf);
                LocalDate fechaPrest = LocalDate.parse(prestamo.getFechaPrestamo(), dtf);
                if (fechaDev.isBefore(fechaPrest)) {
                    System.out.println("Error: La fecha de devolucion no puede ser anterior a la fecha de prestamo.");
                    return;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Error: Formato de fecha incorrecto.");
                return;
            }
            System.out.println("Estas seguro de registrar el prestamo? [1=Si, 2=No]");
            int confirmar2 = leer.nextInt();
            if (confirmar2 == 1) {
                herramienta.setEstado('D');
                prestamo.setFechaDevolucion(fechaDevolucion);
                prestamo.setEstado('C');
                System.out.println("Devolucion registrada exitosamente.");
                catalogo.contConcluidos++;
                catalogo.contActivos--;
            }
        } else {
            System.out.println("No hay prestamos registrados aun");
        }
    }

    private static void consultarPrestamo(Scanner leer, Catalogo catalogo) {

        if (catalogo.getContP() >= 2) {
            System.out.print("Ingrese el numero de préstamo: ");
            int numPrestamo = leer.nextInt();

            Prestamo prestamo = catalogo.buscarPrestamo(numPrestamo);
            if (prestamo != null) {
                Trabajador trabajador = catalogo.buscarTrabajador(prestamo.getIdTrabajador());
                Herramienta herramienta = catalogo.buscarHerramienta(prestamo.getIdHerramienta());
                System.out.println("Id del Trabajador: " + trabajador.getIdTrabajador());
                System.out.printf("Nombre del trabajador: %s\n", trabajador.getNombre());
                System.out.println("Id de la Herramienta: " + herramienta.getIdHerramienta());
                System.out.printf("Nombre de la herramienta: %s\n", herramienta.getNombre());
                System.out.printf("Fecha de prestamo: %s\n", prestamo.getFechaPrestamo());
                System.out.printf("Estado: %s", prestamo.getEstado());

            } else {
                System.out.println("Prestamo no encontrado.");
            }
        } else {
            System.out.println("No hay prestamos registrados aun");
        }
    }

    private static void reportePrestamosActivos(Catalogo catalogo) {

        if (catalogo.getContActivos() >= 1) {
            System.out.println("\nPRESTAMOS ACTIVOS:");
            for (Prestamo p : catalogo.getPrestamos()) {
                if (p != null && p.getEstado() == 'A') {
                    Trabajador trabajador = catalogo.buscarTrabajador(p.getIdTrabajador());
                    Herramienta herramienta = catalogo.buscarHerramienta(p.getIdHerramienta());
                    System.out.println("Id del Trabajador: " + trabajador.getIdTrabajador());
                    System.out.printf("Nombre del trabajador: %s\n", trabajador.getNombre());
                    System.out.println("Id de la Herramienta: " + herramienta.getIdHerramienta());
                    System.out.printf("Nombre de la herramienta: %s\n", herramienta.getNombre());
                    System.out.printf("Fecha de prestamo: %s\n", p.getFechaPrestamo());
                    System.out.println("----------------------------------------------------------");
                }
            }
            System.out.println("Fin del reporte");
        } else {
            System.out.println("No hay prestamos Activos ");
        }
    }

    private static void reportePrestamosConcluidos(Catalogo catalogo) {

        if (catalogo.getContConcluidos() >= 1) {
            System.out.println("\nPRESTAMOS CONCLUIDOS:");
            for (Prestamo p : catalogo.getPrestamos()) {
                if (p != null && p.getEstado() == 'C') {
                    Trabajador trabajador = catalogo.buscarTrabajador(p.getIdTrabajador());
                    Herramienta herramienta = catalogo.buscarHerramienta(p.getIdHerramienta());
                    System.out.println("Id del Trabajador: " + trabajador.getIdTrabajador());
                    System.out.printf("Nombre del trabajador: %s\n", trabajador.getNombre());
                    System.out.println("Id de la Herramienta: " + herramienta.getIdHerramienta());
                    System.out.printf("Nombre de la herramienta: %s\n", herramienta.getNombre());
                    System.out.printf("Fecha de prestamo: %s\n", p.getFechaPrestamo());
                    System.out.printf("Fecha de prestamo: %s\n", p.getFechaDevolucion());
                    System.out.println("----------------------------------------------------------");
                }
            }
            System.out.println("Fin del reporte");
        } else {
            System.out.println("No hay prestamos concluidos aun");
        }
    }
}
