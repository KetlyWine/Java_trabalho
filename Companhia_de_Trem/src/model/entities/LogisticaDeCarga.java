package model.entities;

public class LogisticaDeCarga {
    private Estacao localDeDespejo;
    private Estacao localDeEmbarque;


    public LogisticaDeCarga() {
    }

    public LogisticaDeCarga(Estacao localDeDespejo, Estacao localDeEmbarque) {
        this.localDeDespejo = localDeDespejo;
        this.localDeEmbarque = localDeEmbarque;
    }

    public Estacao getLocalDeDespejo() {
        return localDeDespejo;
    }

    public void setLocalDeDespejo(Estacao localDeDespejo) {
        this.localDeDespejo = localDeDespejo;
    }

    public Estacao getLocalDeEmbarque() {
        return localDeEmbarque;
    }

    public void setLocalDeEmbarque(Estacao localDeEmbarque) {
        this.localDeEmbarque = localDeEmbarque;
    }

    @Override
    public String toString() {
        return "LogisticaDeCarga{" +
                "localDeDespejo=" + localDeDespejo +
                ", localDeEmbarque=" + localDeEmbarque +
                '}';
    }
}
