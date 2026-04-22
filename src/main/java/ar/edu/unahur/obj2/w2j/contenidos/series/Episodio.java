package ar.edu.unahur.obj2.w2j.contenidos.series;

// Cuando una clase en un subpaquete quiere extender una clase del paquete padre, necesita **importarla explícitamente**.

import ar.edu.unahur.obj2.w2j.contenidos.Contenido;

public class Episodio extends Contenido {

    private Integer numero;

    // Constructor
    public Episodio(String titulo, Double costoBase, Integer numero) {
        // Llama al constructor de la clase padre (Contenido)
        super(titulo, costoBase);
        // Inicializa los atributos propios de la clase Episodio
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    @Override
    public Double getCosto() {
        return this.costoBase;
    }
}
