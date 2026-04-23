package ar.edu.unahur.obj2.w2j.planes;

import ar.edu.unahur.obj2.w2j.contenidos.Contenido;
import java.util.List;

public class PlanBasico extends Plan {

    private Integer cantidadDeContenidoBonificado;

    public PlanBasico(Double costoFijo, Integer cantidadDeContenidoBonificado) {
        super(costoFijo);
        this.cantidadDeContenidoBonificado = cantidadDeContenidoBonificado;
    }

    @Override
    public Double getCosto() {
        /* Si vio menos de lo que tiene bonificado, no paga extras. Tenemos que hacer esto porque si por ejemplo, tiene bonificado 15 y ve 7, el código hace `subList(15, 7)`. En Java, si el número de inicio (15) es mayor que el tamaño de la lista (7), **el programa tira un error** (`IndexOutOfBoundsException`). Wollok es más "bueno" y con contenidoVisto.drop(cantidadDeContenidoBonificado) devuelve una lista vacía.

        */
        if (this.contenidoVisto.size() <= cantidadDeContenidoBonificado) {
            return this.costoFijo;
        }

        List<Contenido> contenidoFacturado = this.contenidoVisto.subList(
            cantidadDeContenidoBonificado,
            this.contenidoVisto.size()
        );

        return (
            this.costoFijo +
            contenidoFacturado.stream().mapToDouble(Contenido::getCosto).sum()
        );

        // usamos method reference en vez de un lambda normal...supuestamente es mejor.
    }
}
