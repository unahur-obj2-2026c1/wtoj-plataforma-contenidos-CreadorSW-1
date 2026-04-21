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
