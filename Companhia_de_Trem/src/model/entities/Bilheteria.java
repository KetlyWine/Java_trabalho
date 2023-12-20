package model.entities;

import java.awt.*;
import java.util.ArrayList;

public class Bilheteria {
    private Passageiro passageiro;
    private Bilhete bilhete;
    private ArrayList<Passageiro> passageiros = new ArrayList<>();
    private ArrayList<Bilhete> bilhetes = new ArrayList<>();

    public Bilheteria(Passageiro passageiro, Bilhete bilhete) {
        this.passageiro = passageiro;
        this.bilhete = bilhete;
        passageiros.add(passageiro);
        bilhetes.add(bilhete);
    }

    public ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(ArrayList<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

    public ArrayList<Bilhete> getBilhetes() {
        return bilhetes;
    }

    public void setBilhetes(ArrayList<Bilhete> bilhetes) {
        this.bilhetes = bilhetes;
    }

    public Bilheteria(){}

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public void setPassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Bilhete getBilhete() {
        return bilhete;
    }

    public void setBilhete(Bilhete bilhete) {
        this.bilhete = bilhete;
    }

    public void GerarBilhete(){

    }
    public void relatorio(){

    }
    public boolean verificarIdade(){
        return false;
    }

    @Override
    public String toString() {
        return "Bilheteria{" +
                "passageiro=" + passageiro +
                ", bilhete=" + bilhete +
                ", passageiros=" + passageiros +
                ", bilhetes=" + bilhetes +
                '}';
    }
}
