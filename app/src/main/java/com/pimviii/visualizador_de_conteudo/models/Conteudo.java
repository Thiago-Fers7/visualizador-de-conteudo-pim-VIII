package com.pimviii.visualizador_de_conteudo.models;

import com.google.gson.annotations.SerializedName;

public class Conteudo {
    @SerializedName("id")
    private int id;

    @SerializedName("titulo")
    private String titulo;
    @SerializedName("tipo")
    private String tipo;
    @SerializedName("criadorId")
    private int criadorId;

    public Conteudo(int id, String titulo, String tipo, int criadorId) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.criadorId = criadorId;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getCriadorId() {
        return criadorId;
    }

    public void setCriadorId(int criadorId) {
        criadorId = criadorId;
    }
}
