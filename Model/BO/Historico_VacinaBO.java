/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.BO;

import Model.DAO.ExceptionDAO;
import Model.DAO.Historico_VacinaDAO;
import Model.VO.Vacina;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author multi
 */
public class Historico_VacinaBO {
public Vector<Vacina> calcularPrecoVacinacao(String especie) throws SQLException, ClassNotFoundException, ExceptionDAO{
  Vector<Vacina> vacinas= new Historico_VacinaDAO().selecionarVacinas(especie); 
  float preco=0;
  
  for(int i=0; i<vacinas.size();i++){
  preco=vacinas.elementAt(i).getPreco()+((2/10)*vacinas.elementAt(i).getPreco());//O preco da vacina e igual ao preco de compra mais 20% desse preco
  vacinas.elementAt(i).setPreco(preco);
  }
  return vacinas;}  
}
