package model.entities;

import java.util.List;

public class Reserva {
    private Bilheteria bilheteria;
    private TremPassageiro trem;

    public Reserva(Bilheteria bilheteria, TremPassageiro trem) {
        this.bilheteria = bilheteria;
        this.trem = trem;
    }

    public Bilheteria getBilheteria() {
        return bilheteria;
    }

    public void setBilheteria(Bilheteria bilheteria) {
        this.bilheteria = bilheteria;
    }

    public void mostrarAssentosDisponiveis() {
        List<Integer> assentosDisponiveis = trem.getAssentosDisponiveis();
        if (!assentosDisponiveis.isEmpty()) {
            System.out.println("Os seguintes assentos estão disponíveis:");
            int assentosPorLinha = 4; // ajuste isso para o número de assentos por linha no seu trem
            for (int i = 0; i < assentosDisponiveis.size(); i++) {
                if (i % assentosPorLinha == 0) {
                    System.out.println();
                }
                System.out.print("[" + assentosDisponiveis.get(i) + "] ");
            }
            System.out.println();
        } else {
            System.out.println("Desculpe, não há assentos disponíveis neste trem.");
        }
    }

    public void atribuirAssento(int numeroAssento) {
        List<Integer> assentosDisponiveis = trem.getAssentosDisponiveis();
        if (assentosDisponiveis.contains(numeroAssento)) {
            trem.atribuirAssento(numeroAssento);
            System.out.println("🟢 Assento [" + numeroAssento + "] foi atribuído.");
        } else {
            System.out.println("🔴 Desculpe, o assento [" + numeroAssento + "] não está disponível.");
        }
    }
    public void relatorioReserva() {
        List<Integer> assentosDisponiveis = trem.getAssentosDisponiveis();
        int totalAssentos = trem.getCapacidadeDePassageiros(); // assumindo que você tem um método para obter o total de assentos
        int assentosReservados = totalAssentos - assentosDisponiveis.size();

        System.out.println("Relatório de Reservas:");
        System.out.println("Total de assentos: " + totalAssentos);
        System.out.println("Assentos reservados: " + assentosReservados);
        System.out.println("Assentos disponíveis: " + assentosDisponiveis.size());
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "bilheteria=" + bilheteria +
                '}';
    }
}
