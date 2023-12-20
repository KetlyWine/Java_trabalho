package model.entities;

import java.util.*;


public class Companhia {
    private String nome;
    private int id;
    private List<Empresa> parcerias = new ArrayList<>();
    private List<Contrato> contratos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Estacao> estacoes = new ArrayList<>();
    private LogisticaDeCarga logisticaDeCarga;
    private List<Trem> trens = new ArrayList<>();
    private Map<Estacao, List<Estacao>> graph = new HashMap<>();
    private Map<AbstractMap.SimpleEntry<Estacao, Estacao>, Double> distancias = new HashMap<>();

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
    public void conectarEstacoes(Estacao estacao1, Estacao estacao2, double distancia){
        List<Estacao> estacoesConectadas1 = graph.getOrDefault(estacao1, new ArrayList<>());
        estacoesConectadas1.add(estacao2);
        graph.put(estacao1, estacoesConectadas1);

        List<Estacao> estacoesConectadas2 = graph.getOrDefault(estacao2, new ArrayList<>());
        estacoesConectadas2.add(estacao1);
        graph.put(estacao2, estacoesConectadas2);

        // Adicione a distância entre estacao1 e estacao2 ao mapa de distâncias
        distancias.put(new AbstractMap.SimpleEntry<>(estacao1, estacao2), distancia);
        distancias.put(new AbstractMap.SimpleEntry<>(estacao2, estacao1), distancia);
    }

    public void exibir() {
        for (Map.Entry<Estacao, List<Estacao>> entry : graph.entrySet()) {
            Estacao estacao = entry.getKey();
            List<Estacao> estacoesConectadas = entry.getValue();
            System.out.println("Estação: " + estacao.getNome());
            System.out.println("Estações conectadas:");
            for (Estacao estacaoConectada : estacoesConectadas) {
                double distancia = distancias.get(new AbstractMap.SimpleEntry<>(estacao, estacaoConectada));
                System.out.println("- " + estacaoConectada.getNome() + " (distância: " + distancia + ")");
            }
            System.out.println();
        }
    }

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
