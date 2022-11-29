/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ExceptionDAO;
import Model.DAO.VacinaDAO;
import Model.VO.Animal;
import Model.VO.Vacina;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;


/**
 *
 * @author multi
 */
public class VacinaController {
Validacao vv = new Validacao();     
    
public boolean cadastrarVacina(String especie,String marca,String nome,  float preco, float quantidade,Date data, int unidades) throws SQLException, ClassNotFoundException, ExceptionDAO {
      
        if (vv.validarString(especie) && vv.validarString(marca) && vv.validarString(nome) && preco>0 && quantidade>0 && vv.VerificarValidade(data) && unidades > 0 ){
            
            for(int i=0;i<unidades;i++){
            Vacina vacina= new Vacina(marca, nome, especie, data, preco,quantidade);
            vacina.cadastrarVacina(vacina);
            }
             return true;
        }
        return false;
    }

 public Vector<Vacina> pesquisarVacinaMarca(String marca) throws ClassNotFoundException, ExceptionDAO {
 return new  Vacina().pesquisarVacinaMarca(marca);
 }

 public Vector<Vacina> pesquisarVacinaNome(String nome) throws ClassNotFoundException, ExceptionDAO {
 return new  Vacina().pesquisarVacinaNome(nome);
    }
    
    
}
