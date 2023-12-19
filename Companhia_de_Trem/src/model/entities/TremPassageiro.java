package model.entities;

public class TremPassageiro extends Trem{

    private int capacidadeDePassageiros;
    private double bagageiros;

    public TremPassageiro() {
    }

    public TremPassageiro(int numero, String modelo, Integer potencia, Double numeroVagoes,
                          FonteDeEnergia fonte, int capacidadeDePassageiros, double bagageiros) {
        super(numero, modelo, potencia, numeroVagoes, fonte);
        this.capacidadeDePassageiros = capacidadeDePassageiros;
        this.bagageiros = bagageiros;
    }

    public int getCapacidadeDePassageiros() {
        return capacidadeDePassageiros;
    }

    public void setCapacidadeDePassageiros(int capacidadeDePassageiros) {
        this.capacidadeDePassageiros = capacidadeDePassageiros;
    }

    public double getBagageiros() {
        return bagageiros;
    }

    public void setBagageiros(double bagageiros) {
        this.bagageiros = bagageiros;
    }

    @Override
    public String toString() {
        return "TremPassageiro{" +
                "capacidadeDePassageiros=" + capacidadeDePassageiros +
                ", bagageiros=" + bagageiros +
                '}';
    }
}