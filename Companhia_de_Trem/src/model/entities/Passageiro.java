package model.entities;

public class Passageiro {
    private String nome;
    private String rg;
    private int idade;
    private String endereço;

    public Passageiro() {
    }

    public Passageiro(String nome, String rg, int idade, String endereço) {
        this.nome = nome;
        this.rg = rg;
        this.idade = idade;
        this.endereço = endereço;
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

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    @Override
    public String toString() {
        return "Seus Dados: \n" +
                "Nome: " + nome + '\n' +
                "RG: " + rg + '\n' +
                "Endereço: " + endereço+'\n';
    }
}
