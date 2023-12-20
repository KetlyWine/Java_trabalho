package model.entities;

import java.time.LocalDateTime;

public class Bilhete {
    private int id;
    private Estacao estacaoPartida;
    private Estacao estacaoChegada;
    private Double preco;
    private String pagamento;
    private LocalDateTime dataDaCompra;
    private LocalDateTime dataDePartida;
    private static int count = 0;

    public Bilhete(Estacao estacaoPartida, Estacao estacaoChegada, Double preco, String pagamento,
                   LocalDateTime dataDaCompra, LocalDateTime dataDePartida) {
        this.id = count++;
        this.estacaoPartida = estacaoPartida;
        this.estacaoChegada = estacaoChegada;
        this.preco = preco;
        this.pagamento = pagamento;
        this.dataDaCompra = dataDaCompra;
        this.dataDePartida = dataDePartida;
    }

    public int getId() {
        return id;
    }
    public Estacao getEstacaoPartida() {
        return estacaoPartida;
    }

    public void setEstacaoPartida(Estacao estacaoPartida) {
        this.estacaoPartida = estacaoPartida;
    }

    public Estacao getEstacaoChegada() {
        return estacaoChegada;
    }

    public void setEstacaoChegada(Estacao estacaoChegada) {
        this.estacaoChegada = estacaoChegada;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public LocalDateTime getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(LocalDateTime dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public LocalDateTime getDataDePartida() {
        return dataDePartida;
    }

    public void setDataDePartida(LocalDateTime dataDePartida) {
        this.dataDePartida = dataDePartida;
    }

    @Override
    public String toString() {
        return "------------ Bilhete ------------\n" +
                "id: " + id +
                "\nEstacao de Partida = " + estacaoPartida +
                "\nEstacao de Chegada = " + estacaoChegada +
                "\nValor = " + preco +
                "\nPagamento = " + pagamento +
                "\nData da Compra = " + dataDaCompra +
                "\nData de Partida = " + dataDePartida +
                "\n----------------------------------------\n";
    }
}
