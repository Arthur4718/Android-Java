package com.example.recyclersample.dataModel;

public class infoDataModel {

    private String Titulo;
    private String Valor;
    private Integer sort;

    public infoDataModel(String titulo, String valor, Integer sort) {
        Titulo = titulo;
        Valor = valor;
        this.sort = sort;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
