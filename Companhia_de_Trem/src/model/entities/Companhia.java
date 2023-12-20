package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Companhia {
    private String nome;
    private int id;
    private List<Empresa> parcerias = new ArrayList<>();
    private List<Contrato> contratos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Estacao> estacoes = new ArrayList<>();
    private LogisticaDeCarga logisticaDeCarga;
    private List<Trem> trens = new ArrayList<>();

    public Companhia(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }
    public Companhia(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public List<Empresa> getParcerias() {
        return parcerias;
    }
    public void addParceira(Empresa empresa){
        parcerias.add(empresa);
    }
    public void removaParceria(Empresa empresa) {
        parcerias.remove(empresa);
    }

    public List<Contrato> getContratos() {
        return contratos;
    }
    public void addContrato(Contrato contrato){
        contratos.add(contrato);
    }
    public void removerContrato(Contrato contrato){
        contratos.remove(contrato);
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }
    public void removerReserva(Reserva reserva){
        reservas.remove(reserva);
    }

    public List<Estacao> getEstacoes() {
        return estacoes;
    }
    public void addEstacao(Estacao estacao){
        estacoes.add(estacao);
    }
    public void removerEstacao(Estacao estacao){
        estacoes.remove(estacao);
    }

    public LogisticaDeCarga getLogisticaDeCarga() {
        return logisticaDeCarga;
    }

    public void setLogisticaDeCarga(LogisticaDeCarga logisticaDeCarga) {
        this.logisticaDeCarga = logisticaDeCarga;
    }

    public List<Trem> getTrens() {
        return trens;
    }
    public void addTrem(Trem trem){
        trens.add(trem);
    }
    public void removerTrem(Trem trem){
        trens.remove(trem);
    }
    public void RotasEDestinos(){}

    @Override
    public String toString() {
        return "Companhia{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", parcerias=" + parcerias +
                ", contratos=" + contratos +
                ", reservas=" + reservas +
                ", estacoes=" + estacoes +
                ", logisticaDeCarga=" + logisticaDeCarga +
                ", trems=" + trens +
                '}';
    }
}
