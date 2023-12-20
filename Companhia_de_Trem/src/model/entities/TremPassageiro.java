package model.entities;

import java.util.ArrayList;
import java.util.List;

public class TremPassageiro extends Trem{

    private int capacidadeDePassageiros;
    private double bagageiros;
    private boolean[] assentos;

    public TremPassageiro() {
    }

    public TremPassageiro(int numero, String modelo, Integer potencia, FonteDeEnergia fonte,
                          int numeroVagoes, int capacidadeDePassageiros, double bagageiros) {
        super(numero, modelo, potencia, fonte, numeroVagoes);
        this.capacidadeDePassageiros = capacidadeDePassageiros;
        this.bagageiros = bagageiros;
        assentos = new boolean[capacidadeDePassageiros];
        for (int i = 0; i < capacidadeDePassageiros; i++) {
            assentos[i] = true; // Todos os assentos estão disponíveis no início
        }
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
    public List<Integer> getAssentosDisponiveis() {
        List<Integer> assentosDisponiveis = new ArrayList<>();
        for (int i = 0; i < assentos.length; i++) {
            if (assentos[i]) {
                assentosDisponiveis.add(i+1);
            }
        }
        return assentosDisponiveis;
    }
    public void atribuirAssento(int numeroAssento) {
        if (numeroAssento > 0 && numeroAssento <= assentos.length) {
            assentos[numeroAssento - 1] = false;
        }
    }

    @Override
    public String toString() {
        return "TremPassageiro{" +
                "capacidadeDePassageiros=" + capacidadeDePassageiros +
                ", bagageiros=" + bagageiros +
                '}';
    }
}
