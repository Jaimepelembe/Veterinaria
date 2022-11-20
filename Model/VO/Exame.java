/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.VO;

import Controller.Historico_ExameController;
import Model.DAO.ExameDAO;
import Model.DAO.ExceptionDAO;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author multi
 */
public class Exame {
private String nome;
private int idAnimal,idExame;
private float preco;

   public Exame() {
    }

    public Exame(String nome) {
        this.nome = nome;
    }
    
    public Vector<Animal> selecionarAnimais() throws SQLException, ClassNotFoundException, ExceptionDAO{
    
    return new ExameDAO().selecionarAnimais();
    }
    
 public Vector<Animal> selecionarAnimaisEspecie(String especie) throws SQLException, ClassNotFoundException, ExceptionDAO{
    
    return new ExameDAO().selecionarAnimaisEspecie(especie);
    }
   
public Vector<Exame> selecionarExames() throws SQLException, ClassNotFoundException, ExceptionDAO{
return new ExameDAO().selecionarExames();
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

 

  public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
