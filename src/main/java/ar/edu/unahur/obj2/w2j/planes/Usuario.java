package ar.edu.unahur.obj2.w2j.planes;

import ar.edu.unahur.obj2.w2j.contenidos.Contenido;

public class Usuario {

    private String nombre;
    private Plan plan;

    public Usuario(String nombre, Plan plan) {
        this.nombre = nombre;
        this.plan = plan;
    }

    public Plan getPlan() {
        return plan;
    }

    public void verContenido(Contenido contenido) {
        plan.contenidoVisto.add(contenido);
    }
}
