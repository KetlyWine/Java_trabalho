package model.entities;

public abstract class Trem {
    private int numero;
    private String modelo;
    private Integer potencia;
    private Double numeroVagoes;
    private FonteDeEnergia fonte;

    public Trem(){}


    public Trem(int numero, String modelo, Integer potencia, Double numeroVagoes, FonteDeEnergia fonte) {
        this.numero = numero;
        this.modelo = modelo;
        this.potencia = potencia;
        this.numeroVagoes = numeroVagoes;
        this.fonte = fonte;
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

    public Double getNumeroVagoes() {
        return numeroVagoes;
    }

    public void setNumeroVagoes(Double numeroVagoes) {
        this.numeroVagoes = numeroVagoes;
    }

    public FonteDeEnergia getFonte() {
        return fonte;
    }

    public void setFonte(FonteDeEnergia fonte) {
        this.fonte = fonte;
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
