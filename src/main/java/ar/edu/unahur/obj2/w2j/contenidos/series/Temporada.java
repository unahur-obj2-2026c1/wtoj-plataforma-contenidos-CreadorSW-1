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

    private List<Episodio> episodios = new ArrayList<>();

    public Temporada(String titulo, Double costoBase) {
        super(titulo, costoBase);
    }

    public void agregarEpisodio(Episodio episodio) {
        this.episodios.add(episodio);
    }
}
