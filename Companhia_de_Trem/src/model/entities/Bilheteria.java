package model.entities;

public class Bilheteria {
    private Passageiro passageiro;
    private Bilhete bilhete;

    public Bilheteria(Passageiro passageiro, Bilhete bilhete) {
        this.passageiro = passageiro;
        this.bilhete = bilhete;
    }

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
}
