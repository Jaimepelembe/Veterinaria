/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.VO.Animal;
import Model.VO.Vacina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Valter Boa 53
 */
public class VacinaDAO {
       //Metodo recebe o vacina da model e salva na BD
    public void cadastrarVacina(Vacina vacina) throws SQLException, ClassNotFoundException, ExceptionDAO{
    String sql="insert into vacina(marca,nome,data,quantidade,preco) values (?,?,?,?,?);";
    PreparedStatement pstate=null;
    Connection con=null;
    String nome= vacina.getNome();
    String marca = vacina.getMarca();
    String data = vacina.getMarca();
    Float quantidade = vacina.getQuantidade();
    Float preco = vacina.getPreco();
    int idVacina=vacina.getIdVacina();
    int idVet=vacina.getIdVeterinaria();
        
    try{
    con=new ConnectionBD().getConnection();//Criar conexao
    pstate=con.prepareStatement(sql);//Preparar o Statement
    pstate.setString(1, marca);
    pstate.setString(2, nome);
    pstate.setString(3, data);
    pstate.setFloat(4, quantidade);
    pstate.setFloat(5, preco);
    pstate.setInt(8, idVacina);
    pstate.setInt(9, idVet);
    pstate.executeUpdate();
    pstate.close();
 
    }
    catch(SQLException ex){JOptionPane.showMessageDialog(null, "Erro ao gravar a vacina na base de dados"+ex);
       }
    
    }}