package model.entities;

public class Empresa{

    private String nome;
    private String cnpj;
    private String endereco;
    private int numero;
    private String email;
    private String site;
    private Setor setor;

    public Empresa(String nome, String cnpj, String endereco,
                   int numero, String email, String site, Setor setor) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.numero = numero;
        this.email = email;
        this.site = site;
        this.setor = setor;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "site='" + site + '\'' +
                ", setor=" + setor +
                ", nome='" + nome + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero='" + numero + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
