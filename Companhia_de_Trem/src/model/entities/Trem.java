package model.entities;

public abstract class Trem {
    private int numero;
    private String modelo;
    private Integer potencia;
    private FonteDeEnergia fonte;
    private int numeroVagoes;

    public Trem(){}


    public Trem(int numero, String modelo, Integer potencia,
                 FonteDeEnergia fonte, int numeroVagoes) {
        this.numero = numero;
        this.modelo = modelo;
        this.potencia = potencia;
        this.fonte = fonte;
        this.numeroVagoes = numeroVagoes;
    }

    public int getNumero() {
        return numero;
    }

    public String getModelo() {
        return modelo;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public FonteDeEnergia getFonte() {
        return fonte;
    }

    public void setFonte(FonteDeEnergia fonte) {
        this.fonte = fonte;
    }

    public int getNumeroVagoes() {
        return numeroVagoes;
    }

    public void setNumeroVagoes(int numeroVagoes) {
        this.numeroVagoes = numeroVagoes;
    }

    @Override
    public String toString() {
        return "Trem {" +
                "numero=" + numero +
                ", modelo='" + modelo + '\'' +
                ", potencia=" + potencia +
                ", numeroVagoes=" + numeroVagoes +
                ", fonte=" + fonte +
                '}';
    }
}
