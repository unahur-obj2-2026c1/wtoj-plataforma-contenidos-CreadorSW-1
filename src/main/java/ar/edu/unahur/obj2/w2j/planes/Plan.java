package ar.edu.unahur.obj2.w2j.planes;

import ar.edu.unahur.obj2.w2j.contenidos.Contenido;
import java.util.ArrayList;
import java.util.List;

public abstract class Plan {

    protected Double costoFijo;
    protected List<Contenido> contenidoVisto = new ArrayList<>();

    // Constructor
    public Plan(Double costoFijo) {
        this.costoFijo = costoFijo;
    }

    public abstract Double getCosto();

    public void agregarContenido(Contenido contenido) {
        contenidoVisto.add(contenido);
    }

    public List<Contenido> getContenidoVisto() {
        return contenidoVisto;
    }
}
