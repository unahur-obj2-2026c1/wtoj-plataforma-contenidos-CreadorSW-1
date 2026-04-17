package ar.edu.unahur.obj2.w2j;

// Hagamos la traducción del código en Wollok a Java. Ver el repo de Objetos II assignment-s2-wtoj-plataforma-contenidos donde se codeó la versión en wollok.
public abstract class Contenido {

    private string titulo;
    protected double costoBase;

    // constructor
    public Contenido(string titulo, double costoBase) {
        this.titulo = titulo;
        this.costoBase = costoBase;
    }

    public string getTitulo() {
        return titulo;
    }

    // este es el que van a sobreescribir las clases hijas.
    public double getCostoBase() {
        return costoBase;
    }
}
