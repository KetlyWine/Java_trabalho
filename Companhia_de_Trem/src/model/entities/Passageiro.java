package model.entities;

public class Passageiro {
    private String nome;
    private String rg;
    private int idade;

    public Passageiro() {
    }

    public Passageiro(String nome, String rg, int idade) {
        this.nome = nome;
        this.rg = rg;
        this.idade = idade;;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }



    @Override
    public String toString() {
        return "Passageiro{" +
                "nome='" + nome + '\'' +
                ", rg='" + rg + '\'' +
                ", idade=" + idade +
                '}';
    }
}
