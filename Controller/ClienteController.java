/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DAO.ExceptionDAO;
import Model.VO.Animal;
import Model.VO.Cliente;
import java.sql.SQLException;
import java.util.Vector;

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
 

public Vector<Cliente> pesquisarClienteMorada(String morada) throws SQLException, ClassNotFoundException, ExceptionDAO{
return new Cliente().pesquisarClienteMorada(morada);
}
public Vector<Cliente> pesquisarClienteNome(String nome) throws SQLException, ClassNotFoundException, ExceptionDAO{
return new Cliente().pesquisarClienteNome(nome);
}


public boolean actualizarCliente(int id,String nome, String telefone, String morada) throws SQLException, ClassNotFoundException, ExceptionDAO{
    Validacao vv= new Validacao();
if(vv.validarString(nome) && vv.validarString(telefone) && vv.validarString(morada) &&id>0){//&vv.validarSexo(sexo) && vv.validarString(especie)&&vv.validarString(raca)&& vv.validarString(pelo) &&vv.validarPeso(peso)&& vv.validaeID(idVet)&& vv.validaeID(idCli
 Cliente cliente = new Cliente(nome, telefone, morada);
 cliente.setIdCliente(id);
cliente.actualizarCliente(cliente);
 return true;
 }
 return false;
}
public boolean apagarCliente(int id) throws SQLException, ClassNotFoundException, ExceptionDAO{
 Cliente cliente = new Cliente();
if(id>0){
 cliente.setIdCliente(id);
cliente.apagarCliente(cliente);
 return true;
 }
 return false;
}    
    
    
   
}
