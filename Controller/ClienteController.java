/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ExceptionDAO;
import Model.VO.Animal;
import Model.VO.Cliente;
import java.sql.SQLException;

/**
 *
 * @author multi
 */
public class ClienteController {

    public ClienteController() {
    }
    
    
public boolean cadastrarCliente(String nome, String telefone, String morada) throws SQLException, ClassNotFoundException, ExceptionDAO{
    Validacao vv= new Validacao();
if(vv.validarString(nome) && vv.validarString(telefone) && vv.validarString(morada)){//&vv.validarSexo(sexo) && vv.validarString(especie)&&vv.validarString(raca)&& vv.validarString(pelo) &&vv.validarPeso(peso)&& vv.validaeID(idVet)&& vv.validaeID(idCli
 Cliente cliente = new Cliente(nome, telefone, morada);
 cliente.cadastrarCliente(cliente);
 return true;
 }
 return false;
 }  
    
    
    
    
   
}
