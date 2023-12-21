package model.entities;

public class Estacao {
    private String nome;
    private String endereco;
    private String estadoOperacional;
    private Bilheteria bilheteria;

    public Estacao() {
    }

    public Estacao(String nome, String endereco, String estadoOperacional) {
        this.nome = nome;
        this.endereco = endereco;
        this.estadoOperacional = estadoOperacional;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstadoOperacional() {
        return estadoOperacional;
    }

    public void setEstadoOperacional(String estadoOperacional) {
        this.estadoOperacional = estadoOperacional;
    }

    public Bilheteria getBilheteria() {
        return bilheteria;
    }

    public void setBilheteria(Bilheteria bilheteria) {
        this.bilheteria = bilheteria;
    }

    @Override
    public String toString() {
        return "Estacao{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", estadoOperacional='" + estadoOperacional + '\'' +
                ", bilheteria=" + bilheteria +
                '}';
    }
}
