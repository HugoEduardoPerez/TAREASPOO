package menu;

import cine.Cine;
import cine.Horarios;
import dulceria.Producto;

import java.util.Scanner;
import peliculas.Pelicula;
import salas.Sala;
import usuarios.clientes.Cliente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MenuAdmin {
    private Cine cine;
    private Scanner scanner = new Scanner(System.in);

    public MenuAdmin(Cine cine) {
        this.cine = cine;
    }

    public void mostrarMenuAdmin() {
        int opcion = 0;
        while (opcion != 11) {
            System.out.println("Menu Administrador");
            System.out.println("1. Agregar películas");
            System.out.println("2. Registrar clientes");
            System.out.println("3. Eliminar película");
            System.out.println("4. Agregar producto de dulcería");
            System.out.println("5. Eliminar producto de la dulcería");
            System.out.println("6.- Lista de usuarios registrados: ");
            System.out.println("7.- Registrar un horario:");
            System.out.println("8.- Lista de peliculas registradas: ");
            System.out.println("9.- Lista de productos de dulceria registrados: ");
            System.out.println("10.- Para ver las opciones de clientes: ");
            System.out.println("11. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcion) {
                case 1:
                System.out.println("Seleccionaste la opcion para registrar una pelicula. ");
                String idPelicula = cine.generarIdPelicula();
                System.out.println("Ingresa el titulo de la pelicula: ");
                String titulo = scanner.nextLine();
                System.out.println("Ingresa el genero de la pelicula: ");
                String genero = scanner.nextLine();
                System.out.println("Ingresa la clasificacion: ");
                String clasificacion = scanner.nextLine();
                System.out.println("Ingresa la duracion en minutos: ");
                int duracion = scanner.nextInt();
                System.out.println("Ingresa la sinopsis :"); 
                String sinopsis = scanner.nextLine();
                scanner.nextLine();
                Pelicula pelicula = new Pelicula(idPelicula, titulo, genero, clasificacion, duracion, sinopsis);
                cine.aniadirPelicula(pelicula);
                System.out.println("Pelicula agregada con el id: "+pelicula.getId()+" correctamente." );

                    break;
                case 2:
                System.out.println("\nSeleccionaste la opción para Registrar cliente");
                String id = cine.generarIdCliente();
                System.out.println("Ingresa el nombre del cliente: ");
                String nombrecliente= scanner.nextLine();
                System.out.println("Ingrese apellidos del cliente: ");
                String apellidos = scanner.nextLine();
                System.out.println("Ingresa el anio de nacimiento del cliente:");
                int dia = scanner.nextInt();
                System.out.println("Ingresa el mes: ");
                int mes = scanner.nextInt();
                System.out.println("Ingresa el dia: ");
                int anio = scanner.nextInt();
                LocalDate fechaDeNacimiento =LocalDate.of(dia, mes, anio);
                System.out.println("Ingrese su curp: ");
                String curp = scanner.nextLine();
                System.out.println("Ingrese su direccion: ");
                String direccion = scanner.nextLine();
                Cliente cliente = new Cliente(id,curp,nombrecliente,apellidos,direccion,fechaDeNacimiento);
                cine.aniadirCliente(cliente);
                System.out.println("Cliente registrado correctamente.");
                    break;
                case 3:
                    System.out.println("Eliminar película...");
                    System.out.println("Ingresa el id de la pelicula a eliminar: ");
                    String idPeliculaEliminar = scanner.nextLine();
                    cine.eliminarPelicula(idPeliculaEliminar);
                    break;
                case 4:
                String idpd = cine.generarIdProducto();
                    System.out.println("Agregar producto de dulcería...");
                    String idP = cine.generarIdProducto();
                    System.out.println("Ingresa el nombre del producto: ");
                    String nomP = scanner.nextLine();
                    System.out.println("Ingrese el precio del producto: ");
                    Double precioP = scanner.nextDouble();
                    Producto producto = new Producto(idP, nomP, precioP);
                    cine.aniadirProductoADulceria(producto);
                    System.out.println("Producto registrado correctamnete-" +producto.getNombre()+"Id: "+idpd);

                    break;
                case 5:
                    System.out.println("Eliminar producto de la dulcería...");
                    System.out.println("Ingrese id del producto: ");
                    String idPe = scanner.nextLine();
                    cine.eliminarProductoDulceria(idPe);
                    break;
                case 6:
                    System.out.println("USUARIOS REGISTRADOS: ");
                    cine.mostrarClientes();
                    break;

                case 7: 
                
            System.out.println("Seleccionaste la opción para registrar un horario.");

            // Seleccionar la película
            System.out.println("Lista de películas disponibles: ");
            cine.mostrarPeliculas();
            System.out.println("Ingresa el ID de la película para asignar al horario:");
            String idPeliculaHorario = scanner.nextLine();
            Pelicula peliculaSeleccionada = cine.buscarPeliculaPorId(idPeliculaHorario);
            
            if (peliculaSeleccionada == null) {
                System.out.println("Película no encontrada. Volviendo al menú.");
                break;
            }


            System.out.println("Lista de salas disponibles: ");
            cine.mostrarSalas();
            System.out.println("Ingresa el ID de la sala para asignar el horario:");
            String idSalaHorario = scanner.nextLine();
            Sala salaSeleccionada = cine.buscarSalaPorId(idSalaHorario);
            
            if (salaSeleccionada == null) {
                System.out.println("Sala no encontrada. Volviendo al menú.");
                break;
            }

            System.out.println("Ingresa el año del horario:");
            int anioHorario = scanner.nextInt();
            System.out.println("Ingresa el mes (1-12) del horario:");
            int mesHorario = scanner.nextInt();
            System.out.println("Ingresa el día del horario:");
            int diaHorario = scanner.nextInt();
            System.out.println("Ingresa la hora (0-23) del horario:");
            int horaHorario = scanner.nextInt();
            System.out.println("Ingresa los minutos (0-59) del horario:");
            int minutoHorario = scanner.nextInt();
            
            LocalDateTime fechaHora = LocalDateTime.of(anioHorario, mesHorario, diaHorario, horaHorario, minutoHorario);
            
            Horarios nuevoHorario = new Horarios(fechaHora, idSalaHorario, idPeliculaHorario);
            salaSeleccionada.agregarHorario(nuevoHorario);
            
            System.out.println("Horario registrado correctamente: " + nuevoHorario);
                break;
                
                case 8:
                System.out.println("Lista de peliculas registradas: ");
                cine.mostrarPeliculas();
                break;

                case 9:
                cine.mostrarProductosDulceria();
                break;
                case 10:
                    System.out.println("Cambiando al menú de cliente...");
                    MenuCliente menuCliente = new MenuCliente(cine); // Pasar instancia de Cine
                    menuCliente.MostrarMenuCliente(); // Mostrar el menú del cliente
                    break;
                case 11:
                break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
    }

