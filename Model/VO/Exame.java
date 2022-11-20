/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.VO;

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
private int idAnimal,idVeterinaria;

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
    
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getIdVeterinaria() {
        return idVeterinaria;
    }

    public void setIdVeterinaria(int idVeterinaria) {
        this.idVeterinaria = idVeterinaria;
    }

 

  public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}
