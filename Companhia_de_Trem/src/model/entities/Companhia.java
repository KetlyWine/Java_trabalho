package model.entities;

import java.util.ArrayList;

public class Companhia {
    private String nome;
    private int id;
    private ArrayList<Empresa> parcerias = new ArrayList<>();
    private ArrayList<Contrato> contratos = new ArrayList<>();
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private ArrayList<Estacao> estacoes = new ArrayList<>();
    private LogisticaDeCarga logisticaDeCarga;
    private ArrayList<Trem> trems = new ArrayList<>();

    public Companhia(String nome, int id, LogisticaDeCarga logisticaDeCarga) {
        this.nome = nome;
        this.id = id;
        this.logisticaDeCarga = logisticaDeCarga;
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

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Empresa> getParcerias() {
        return parcerias;
    }
    public void addParceira(Empresa empresa){
        parcerias.add(empresa);
    }
    public void setParcerias(ArrayList<Empresa> parcerias) {
        this.parcerias = parcerias;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }
    public void addContrato(Contrato contrato){
        contratos.add(contrato);
    }
    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    public void addReserva(Reserva reserva){
        reservas.add(reserva);
    }
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ArrayList<Estacao> getEstacoes() {
        return estacoes;
    }
    public void addEstacao(Estacao estacao){
        estacoes.add(estacao);
    }
    public void setEstacoes(ArrayList<Estacao> estacoes) {
        this.estacoes = estacoes;
    }

    public LogisticaDeCarga getLogisticaDeCarga() {
        return logisticaDeCarga;
    }

    public void setLogisticaDeCarga(LogisticaDeCarga logisticaDeCarga) {
        this.logisticaDeCarga = logisticaDeCarga;
    }

    public ArrayList<Trem> getTrems() {
        return trems;
    }
    public void addTrem(Trem trem){
        trems.add(trem);
    }
    public void setTrems(ArrayList<Trem> trems) {
        this.trems = trems;
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
                ", trems=" + trems +
                '}';
    }
}
