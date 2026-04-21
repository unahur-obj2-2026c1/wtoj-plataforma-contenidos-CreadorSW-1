package ar.edu.unahur.obj2.w2j.planes;

public class PlanFamiliar extends PlanBasico {

    private Integer cantidadDeUsuarios;

    public PlanFamiliar(
        Double costoFijo,
        Integer cantidadDeContenidoBonificado,
        Integer cantidadDeUsuarios
    ) {
        super(costoFijo, cantidadDeContenidoBonificado);
        this.cantidadDeUsuarios = cantidadDeUsuarios;
    }

    @Override
    public Double getCosto() {
        return this.costoFijo * (1 - 0.15 * cantidadDeUsuarios);
    }
}
