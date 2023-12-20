package model.entities;

public class Reserva {
    private Bilheteria bilheteria;

    public Reserva(Bilheteria bilheteria) {
        this.bilheteria = bilheteria;
    }

    public Bilheteria getBilheteria() {
        return bilheteria;
    }

    public void setBilheteria(Bilheteria bilheteria) {
        this.bilheteria = bilheteria;
    }

    public void verificarAssentosDisponiveis(){

    }
    public void atribuirAssento(){

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
