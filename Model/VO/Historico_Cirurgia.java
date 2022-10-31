/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.VO;

/**
 *
 * @author multi
 */
public class Historico_Cirurgia {
private int idAnimal,idCirurgia;
private float preco;
private String data, observacao;//A data refere-se a data de realizacao ,deve ser gerada automaticamente

    public Historico_Cirurgia() {
    }

    public Historico_Cirurgia(int idAnimal, int idCirurgia, float preco, String data, String observacao) {
        this.idAnimal = idAnimal;
        this.idCirurgia = idCirurgia;
        this.preco = preco;
        this.data = data;
        this.observacao = observacao;
    }

    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdCirurgia() {
        return idCirurgia;
    }

    public void setIdCirurgia(int idCirurgia) {
        this.idCirurgia = idCirurgia;
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


    
}
