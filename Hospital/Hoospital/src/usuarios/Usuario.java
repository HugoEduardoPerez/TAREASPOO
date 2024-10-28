package usuarios;

import usuarios.utils.Rol;

import java.time.LocalDate;

public class Usuario {
    public String id;
    public String nombre;
    public String apellidos;
    public LocalDate fechaNacimiento;
    public String telefono;
    public String email;
    private String contrasenia;
    public Rol rol; //PACIENTE, ADMIN, MEDICO USAR ENUMS.


    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }
    public Rol getRol() {
        return rol;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Usuario(String id, String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String contrasenia, Rol rol, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.email=email;
    }
    protected String mostrarInformacion(){
        String nombreCompleto = this.nombre +" "+this.apellidos;
        String datos = String.format(
                "\nId: %s, nombre completo:%s, fecha de nacimiento: %s, telefono: %s",this.id,nombreCompleto,this.fechaNacimiento,this.telefono);


        return datos;

    }

}