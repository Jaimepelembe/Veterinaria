/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ExameDAO;
import Model.DAO.ExceptionDAO;
import Model.VO.Animal;
import Model.VO.Exame;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author multi
 */
public class ExameController {
public Vector<Animal> selecionarAnimais() throws SQLException, ClassNotFoundException, ExceptionDAO{
return new Exame().selecionarAnimais();
}

public Vector<Animal> selecionarAnimaisEspecie(String especie) throws SQLException, ClassNotFoundException, ExceptionDAO{
return new Exame().selecionarAnimaisEspecie(especie);
}

public Vector<Exame> selecionarExames() throws SQLException, ClassNotFoundException, ExceptionDAO{
return new Exame().selecionarExames();
} 


  
}
