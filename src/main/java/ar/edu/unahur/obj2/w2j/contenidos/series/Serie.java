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

    // method cantidadEpisodiosTotales()
    public Integer cantidadEpisodiosTotales() {
        return temporadas.stream().mapToInt(Temporada::cantidadEpisodios).sum();
    }

    // override method costo()
    @Override
    public Double getCosto() {
        int totalEpisodios = this.cantidadEpisodiosTotales();

        // Si no hay episodios, el promedio no existe, cobramos solo el base. ATENCIÓN: con esta forma nos permitimos poner 2 returns....(Cláusula de guardia)
        if (totalEpisodios == 0) {
            return this.costoBase;
        }

        Double sumaCostoTemporadas = temporadas
            .stream()
            .mapToDouble(Temporada::getCosto)
            .sum();

        return (
            this.costoBase +
            (sumaCostoTemporadas / this.cantidadEpisodiosTotales())
        );
    }
}
