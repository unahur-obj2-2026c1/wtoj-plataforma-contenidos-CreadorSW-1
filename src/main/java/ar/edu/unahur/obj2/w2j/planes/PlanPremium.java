package ar.edu.unahur.obj2.w2j.planes;

public class PlanPremium extends Plan {

    private Double costoMensual;

    public PlanPremium(Double costoFijo, Double costoMensual) {
        super(costoFijo);
        this.costoMensual = costoMensual;
    }

    @Override
    public Double getCosto() {
        return this.costoMensual;
    }
}
