package ar.edu.unahur.obj2.w2j.contenidos.series;

import ar.edu.unahur.obj2.w2j.contenidos.Contenido;
/*
`java.lang` es el único paquete que Java importa **automáticamente** en todos los programas. Este paquete incluye clases fundamentales como:

- `Integer`, `Double`, `Boolean`, `String`
- `System`, `Object`, `Thread`, `Math`

En cambio, `List` está en `java.util`, que **no** es parte de `java.lang`. Por eso se necesita el import explícito.
*/

import java.util.ArrayList;
import java.util.List;

// Constructor
public class Temporada extends Contenido {

    private Integer numero;
    private List<Episodio> episodios = new ArrayList<>();

    // Si invocamos al constructor del padre, necesitamos que tenga todos los parámetros.
    public Temporada(String titulo, Double costoBase, Integer numero) {
        super(titulo, costoBase);
        this.numero = numero;
    }

    public void agregarEpisodio(Episodio episodio) {
        this.episodios.add(episodio);
    }

    public Integer cantidadEpisodios() {
        return this.episodios.size();
    }

    @Override
    public Double getCosto() {
        return this.episodios.stream().mapToDouble(Episodio::getCosto).sum();
    }
}
