package ar.edu.unahur.obj2.w2j.contenidos.series;

import ar.edu.unahur.obj2.w2j.contenidos.Contenido;
import java.util.ArrayList;
import java.util.List;

public class Serie extends Contenido {

    private List<Temporada> temporadas = new ArrayList<>();

    public Serie(String titulo, Double costoBase) {
        super(titulo, costoBase);
    }

    public void agregarTemporada(Temporada temporada) {
        this.temporadas.add(temporada);
    }
}
