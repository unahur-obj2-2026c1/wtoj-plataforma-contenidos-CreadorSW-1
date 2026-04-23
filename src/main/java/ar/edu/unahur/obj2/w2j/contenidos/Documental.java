package ar.edu.unahur.obj2.w2j.contenidos;

public class Documental extends Contenido {

    private Double cannonIDRA = 0.5;

    public Documental(String titulo, Double costoBase) {
        super(titulo, costoBase);
    }

    public Double getCannonIDRA() {
        return cannonIDRA;
    }

    public void setCannonIDRA(Double cannonIDRA) {
        this.cannonIDRA = cannonIDRA;
    }

    @Override
    public Double getCosto() {
        return this.costoBase + this.costoBase * cannonIDRA;
    }
}
