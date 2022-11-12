/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.DAO.ExceptionDAO;
import Model.VO.Vacina;
import java.sql.SQLException;

/**
 *
 * @author Valter Boa 53
 */
public class VacinaController {
    
    public VacinaController(){
    
    }
    
    //marca,nome,data,quantidade,prec
    
    public boolean cadastrarVacina(String marca, String nome, String data, Float quantidade, Float preco) throws SQLException, ClassNotFoundException, ExceptionDAO{
    Validacao vv= new Validacao();
if(vv.validarString(nome) && vv.validarString(marca) && vv.validarString(data)){//&vv.validarSexo(sexo) && vv.validarString(especie)&&vv.validarString(raca)&& vv.validarString(pelo) &&vv.validarPeso(peso)&& vv.validaeID(idVet)&& vv.validaeID(idCli
 Vacina vacina = new Vacina(marca, nome,data, quantidade, preco);
 vacina.cadastrarVacina(vacina);
 return true;
 }
 return false;
 }  

  
    
    
    
    
    
}
