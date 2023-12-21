package model.entities;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Bilheteria {
    private Passageiro passageiro;
    private List<Bilhete> bilhetes = new ArrayList<>();

    public Bilheteria(Passageiro passageiro){
        this.passageiro = passageiro;
    }

    public void adicionarBilhete(Bilhete bilhete){
        bilhetes.add(bilhete);
    }
    public void cancelarBilhete(Bilhete bilhete){
        bilhetes.remove(bilhete);
    }

    public void mudarPassageiro(Passageiro passag){
        passageiro = passag;
    }

    public String imprimirBilhete() {
        try {
            int tamanho = bilhetes.size();
            if (tamanho > 0) {
                return bilhetes.get(tamanho - 1).toString();
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("A lista de bilhetes está vazia. Não é possível imprimir o bilhete.");
        }
        return "Nenhum bilhete disponível.";
    }

    public double valor(double km){
        if (km < 20.0){
            return 5.0;
        } else if( km < 50){
            return 6.0;
        } else if (km < 100) {
            return 10.0;
        } else if (km < 200) {
            return 30.0;
        } else
            return 50.0;
    }
    public void relatorio(){
        double valor_arrecadado = 0;
        int quantidade = 0;

        System.out.println("\t----- Relatório dos bilhetes vendidos -----\n");
        for (Bilhete bilhete : bilhetes){
            System.out.println(bilhete.toString());
            valor_arrecadado += bilhete.getPreco();
            quantidade++;
        }
        System.out.printf("Valor arrecadado: %.2f\nQuantidade vendida: %d", valor_arrecadado, quantidade);
    }
    public boolean verificarIdade(){
        if (passageiro.getIdade() < 12)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Bilheteria{" +
                "passageiro=" + passageiro +
                ", bilhetes=" + bilhetes +
                '}';
    }
}
