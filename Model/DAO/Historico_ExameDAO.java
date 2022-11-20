/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.VO.Exame;
import Model.VO.Historico_Exame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author multi
 */
public class Historico_ExameDAO {
  public void cadastrarExame(Historico_Exame historico) throws SQLException, ClassNotFoundException, ExceptionDAO{
    String sql="insert into historico_exame (idAnimal,idExame,data_realizacao,resultado,observacao) values (?,?,?,?,?);";
    PreparedStatement pstate=null;
    Connection con=null;
    int idAnimal= historico.getIdAnimal();
    int idExame= historico.getIdExame();
    String data=historico.getData();
    String resultado=historico.getResultado();
    String observacao=historico.getObservacao();
    
    try{
    con=new ConnectionBD().getConnection();//Criar conexao
    pstate=con.prepareStatement(sql);//Preparar o Statement
    pstate.setInt(1, idAnimal);
    pstate.setInt(2, idExame);
    pstate.setString(3, data);
    pstate.setString(4, resultado);
    pstate.setString(5, observacao);
    pstate.executeUpdate();
    pstate.close();
 
    }
    catch(SQLException ex){JOptionPane.showMessageDialog(null, "Erro ao gravar o historico na base de dados"+ex);
       }
    //Fechar prepared Statement e connection
    finally{ ConnectionBD cm= new ConnectionBD();
    cm.fecharConexao(pstate, con);
    }
    }
    
    
}
