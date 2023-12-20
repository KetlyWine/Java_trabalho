package model.entities;

import java.time.LocalDate;

public class Contrato {
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private double orcamento;
    private String tipoDeCarga;
    private Empresa empresa;

    public Contrato(LocalDate dataInicio, LocalDate dataFim,
                    double orcamento, String tipoDeCarga, Empresa empresa) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.orcamento = orcamento;
        this.tipoDeCarga = tipoDeCarga;
        this.empresa = empresa;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public String getTipoDeCarga() {
        return tipoDeCarga;
    }

    public void setTipoDeCarga(String tipoDeCarga) {
        this.tipoDeCarga = tipoDeCarga;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    public void ImprimirContrato(){}

    @Override
    public String toString() {
        return "Contrato{" +
                "dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", orcamento=" + orcamento +
                ", tipoDeCarga='" + tipoDeCarga + '\'' +
                ", empresa=" + empresa +
                '}';
    }
}
