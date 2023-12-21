package model.entities;

import java.util.*;


public class Companhia {
    private String nome;
    private int id;
    private List<Empresa> parcerias = new ArrayList<>();
    private List<Contrato> contratos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private List<Estacao> estacoes = new ArrayList<>();
    private List<Estacao> estacoesDisponiveis;
    private LogisticaDeCarga logisticaDeCarga;
    private List<Trem> trens = new ArrayList<>();
    private List<Empresa> empresas = new ArrayList<>();
    private Map<Estacao, List<Estacao>> graph = new HashMap<>();
    private Map<AbstractMap.SimpleEntry<Estacao, Estacao>, Double> distancias = new HashMap<>();

    public Companhia(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }
    public Companhia(List<Estacao> estacoes) {
        this.estacoes = new ArrayList<>(estacoes);
        this.estacoesDisponiveis = new ArrayList<>(estacoes);
    }
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

    public List<Empresa> getEmpresas() {
        return empresas;
    }
    public void addEmpresa(Empresa empresa){
        empresas.add(empresa);
    }
    public void removaEmpresa(Empresa empresa) {
        empresas.remove(empresa);
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

    public double obterDistanciaEntreEstacoes(Estacao estacao1, Estacao estacao2) {
        // Verifica se a distância está presente no mapa de distâncias
        if (distancias.containsKey(new AbstractMap.SimpleEntry<>(estacao1, estacao2))) {
            return distancias.get(new AbstractMap.SimpleEntry<>(estacao1, estacao2));
        } else {
            return -1; // Valor padrão ou outra lógica adequada
        }
    }

    public void exibir() {
        System.out.printf("%-20s %-20s %s%n", "Estação", "Estação Conectada", "Distância");
        System.out.println("-----------------------------------------------------");
        int i = 1;
        for (Map.Entry<Estacao, List<Estacao>> entry : graph.entrySet()) {
            Estacao estacao = entry.getKey();
            List<Estacao> estacoesConectadas = entry.getValue();
            for (Estacao estacaoConectada : estacoesConectadas) {
                double distancia = distancias.get(new AbstractMap.SimpleEntry<>(estacao, estacaoConectada));
                System.out.printf("%d - %-20s %-20s %.2f%n", i, estacao.getNome(), estacaoConectada.getNome(), distancia);
                i++;
            }
        }
    }
    public void mostrarEstacoesDisponiveis() {
        if (!estacoesDisponiveis.isEmpty()) {
            System.out.println("Estações disponíveis para escolha:");
            for (int i = 0; i < estacoesDisponiveis.size(); i++) {
                System.out.println(i + ". " + estacoesDisponiveis.get(i).getNome());
            }
        } else {
            System.out.println("Não há mais estações disponíveis.");
        }
    }
    public void escolherEstacoes(Scanner ler) {
        System.out.println("Escolha as estações (digite os números separados por espaço):");
        if (ler.hasNextLine()) {
            String input = ler.nextLine();
            String[] numeros = input.split(" ");

            for (String nume : numeros) {
                try {
                    int i = Integer.parseInt(nume);
                    if (i >= 0 && i < estacoesDisponiveis.size()) {
                        Estacao estacaoEscolhida = estacoesDisponiveis.get(i);
                        System.out.println("Estação escolhida: " + estacaoEscolhida.getNome());
                        // Adicionar estação à companhia (você pode personalizar essa lógica)
                        // companhiaecia.addEstacao(estacaoEscolhida);

                        // Remover estação da lista de estações disponíveis
                        estacoesDisponiveis.remove(estacaoEscolhida);
                    } else {
                        System.out.println("Número inválido: " + nume);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Formato inválido: " + nume);
                }
            }
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
