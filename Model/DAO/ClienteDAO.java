/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.VO.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author multi
 */
public class ClienteDAO {
    public ClienteDAO(){};
   
    public void cadastrarCliente(Cliente cliente) throws SQLException, ClassNotFoundException, ExceptionDAO{
    String sql="insert into cliente (nome,telefone,morada,idVeterinaria) values (?,?,?,?)";
    PreparedStatement pstate=null;
    Connection con=null;
    String nome=cliente.getNome();
    String telefone = cliente.getTelefone();
    String morada = cliente.getMorada();
        
    try{
    con=new ConnectionBD().getConnection();//Criar conexao
    pstate=con.prepareStatement(sql);//Preparar o Statement
    pstate.setString(1, nome);
    pstate.setString(2, telefone);
    pstate.setString(3, morada);
    pstate.setInt(4, 1);//idVeterinaria
    pstate.executeUpdate();
    pstate.close();
    
    System.out.println(cliente.toString());//teste
    }
    catch(SQLException ex){JOptionPane.showMessageDialog(null, "Erro ao gravar o actor na base de dados"+ex);
       }
    //Fechar prepared Statement e connection
    finally{ ConnectionBD cm= new ConnectionBD();
    cm.fecharConexao(pstate, con);
    }
    }
}

    


