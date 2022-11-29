/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.VO;

import Model.DAO.ExameDAO;
import Model.DAO.ExceptionDAO;
import Model.DAO.Historico_CirurgiaDAO;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;


/**
 *
 * @author multi
 */
public class Historico_Cirurgia {
private int idAnimal,idCirurgia;
private float preco;
private String observacao;//A data refere-se a data de realizacao ,deve ser gerada automaticamente
private Date data;
    public Historico_Cirurgia() {
    }

    public Historico_Cirurgia(int idAnimal, int idCirurgia, float preco, Date data, String observacao) {
        this.idAnimal = idAnimal;
        this.idCirurgia = idCirurgia;
        this.preco = preco;
        this.data = data;
        this.observacao = observacao;
    }

    public void cadastrarHistorico(Historico_Cirurgia historico) throws SQLException, ClassNotFoundException, ExceptionDAO{
    
    new Historico_CirurgiaDAO().cadastrarHistorico(historico);
    }
    
//  public Vector<Animal>selecionarAnimaisEspecie(String especie) throws SQLException, ClassNotFoundException, ExceptionDAO{
// 
// return new ExameDAO().selecionarAnimaisEspecie(especie);}
  
      
  public Vector<Cirurgia> selecionarCirurgias() throws SQLException, ClassNotFoundException, ExceptionDAO{
 
 return new Historico_CirurgiaDAO().selecionarCirurgias();}
    
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }


    
}
