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

    public void mostrarAssentosDisponiveis(){
        List<Integer> assentosDisponiveis = trem.getAssentosDisponiveis();
        if (!assentosDisponiveis.isEmpty()) {
            System.out.println("Os seguintes assentos estão disponíveis: " + assentosDisponiveis);
        } else {
            System.out.println("Desculpe, não há assentos disponíveis neste trem.");
        }
    }
    public void atribuirAssento(int numeroAssento){
        List<Integer> assentosDisponiveis = trem.getAssentosDisponiveis();
        if (assentosDisponiveis.contains(numeroAssento)) {
            
            System.out.println("Assento " + numeroAssento + " foi atribuído.");
        } else {
            System.out.println("Desculpe, o assento " + numeroAssento + " não está disponível.");
        }
    }
    public void relatorioReserva(){

    }

    @Override
    public String toString() {
        return "Reserva{" +
                "bilheteria=" + bilheteria +
                '}';
    }
}
