/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ExameDAO;
import Model.DAO.ExceptionDAO;
import Model.DAO.Historico_CirurgiaDAO;
import Model.VO.Animal;
import Model.VO.Cirurgia;
import Model.VO.Exame;
import Model.VO.Historico_Cirurgia;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author multi
 */
public class Historico_CirurgiaController {
  
 public void cadastrarHistorico(Historico_Cirurgia historico) throws SQLException, ClassNotFoundException, ExceptionDAO{
    new Historico_Cirurgia().cadastrarHistorico(historico);
    } 
 
 public Vector<Animal>selecionarAnimaisEspecie(String especie) throws SQLException, ClassNotFoundException, ExceptionDAO{
 
 return new Exame().selecionarAnimaisEspecie(especie);
 }
 
 public Vector<Cirurgia> selecionarCirurgias() throws SQLException, ClassNotFoundException, ExceptionDAO{
 
 return new Historico_Cirurgia().selecionarCirurgias();}
    
}
