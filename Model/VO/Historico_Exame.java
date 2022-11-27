/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.VO;

import Controller.Historico_ExameController;
import Model.DAO.ExceptionDAO;
import Model.DAO.Historico_ExameDAO;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author multi
 */
public class Historico_Exame {
 private int idAnimal,idExame,idHistorico;
private float preco;
private String observacao,resultado;
private Date data; //A data refere-se a data de realizacao ,deve ser gerada automaticamente pelo sistema
    public Historico_Exame() {
    }

    public Historico_Exame(int idAnimal, int idExame, int idHistorico, float preco, String observacao, String resultado, Date data) {
        this.idAnimal = idAnimal;
        this.idExame = idExame;
        this.idHistorico = idHistorico;
        this.preco = preco;
        this.observacao = observacao;
        this.resultado = resultado;
        this.data = data;
    }


    
    public void CadastrarHistorico(Historico_Exame historico) throws SQLException, ClassNotFoundException, ExceptionDAO{
   new Historico_ExameDAO().cadastrarExame(historico);
    }
   public int selecionaridHistorico() throws SQLException, ClassNotFoundException, ExceptionDAO{
return new Historico_ExameDAO().idHistoricoExame() ;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
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
