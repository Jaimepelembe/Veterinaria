/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author multi
 */
public class Historico_Exame {
 private int idAnimal,idExame;
private float preco;
private String data, observacao,resultado;//A data refere-se a data de realizacao ,deve ser gerada automaticamente

    public Historico_Exame() {
    }

    public Historico_Exame(int idAnimal, int idExame, float preco, String data, String observacao, String resultado) {
        this.idAnimal = idAnimal;
        this.idExame = idExame;
        this.preco = preco;
        this.data = data;
        this.observacao = observacao;
        this.resultado = resultado;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdExame() {
        return idExame;
    }

    public void setIdExame(int idExame) {
        this.idExame = idExame;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
 

}
