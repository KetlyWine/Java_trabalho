package model.entities;

public class  TremCarga extends Trem{
    private Double capacidadeDeCarga;
    private Double cargaDisponivel;

    public TremCarga(int numero, String modelo, Integer potencia, int numeroVagoes,
                     FonteDeEnergia fonte, double capacidadeDeCarga) {
        super(numero, modelo, potencia,fonte, numeroVagoes);
        this.capacidadeDeCarga = capacidadeDeCarga;
        this.cargaDisponivel = capacidadeDeCarga;
    }

    public Double getCapacidadeDeCarga() {
        return capacidadeDeCarga;
    }

    public Double getCargaDisponível() {
        return cargaDisponivel;
    }

    public void carregar(Double carga) {
        try {
            if (carga <= cargaDisponivel){
                cargaDisponivel -= carga;
            } else {
                throw  new IllegalStateException("A carga excede a carga disponível.");
            }
        } catch (IllegalStateException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void descarregar(Double carga) {
        try {
            if (carga >= 0 && (cargaDisponivel + carga) <= capacidadeDeCarga) {
                cargaDisponivel += carga;
            } else {
                throw new IllegalStateException("A carga excede a capacidade máxima permitida.");
            }
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

}
