package ar.edu.unahur.obj2.w2j.contenidos;

// Hagamos la traducción del código en Wollok a Java. Ver el repo de Objetos II assignment-s2-wtoj-plataforma-contenidos donde se codeó la versión en wollok.
public abstract class Contenido {

    private String titulo;
    protected Double costoBase;

    // constructor
    public Contenido(String titulo, Double costoBase) {
        this.titulo = titulo;
        this.costoBase = costoBase;
    }

    public String getTitulo() {
        return titulo;
    }

    // este es el que van a sobreescribir las clases hijas.
    public Double getCosto() {
        return costoBase;
    }
}
