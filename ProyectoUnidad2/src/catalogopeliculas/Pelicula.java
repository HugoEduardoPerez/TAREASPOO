package catalogopeliculas;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    private String id;
    private String titulo;
    private String genero;
    private String clasificacion;
    private int duracion; // en minutos
    private String sinopsis;
    private ArrayList<String> horarios= new ArrayList<>(); // Lista de horarios disponibles

    // Constructor
    public Pelicula(String id, String titulo, String genero, String clasificacion, int duracion, String sinopsis) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.clasificacion = clasificacion;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.horarios = new ArrayList<>();
    }


    // Getters y Setters
    public String getId() {
        return id;
    }

    public void getTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void getGenero(String genero) {
        this.genero = genero;
    }

    public void getClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void getDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void getSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


    public String getTitulo() {
        return titulo;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setHorarios(ArrayList<String> horarios) {
        this.horarios = horarios;
    }
}



