/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.VO.Animal;
import Model.VO.Exame;
import Model.VO.Historico_Exame;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author multi
 */
public class Historico_ExameDAO {
  public void cadastrarExame(Historico_Exame historico) throws SQLException, ClassNotFoundException, ExceptionDAO{
    String sql="insert into historico_exame (idAnimal,idExame,idHistorico,data_realizacao,resultado,observacao) values (?,?,?,?,?,?);";
    PreparedStatement pstate=null;
    Connection con=null;
    int idAnimal= historico.getIdAnimal();
    int idExame= historico.getIdExame();
    int idHistorico=historico.getIdHistorico();
    Date data=historico.getData();
    String resultado=historico.getResultado();
    String observacao=historico.getObservacao();
    
    try{
    con=new ConnectionBD().getConnection();//Criar conexao
    pstate=con.prepareStatement(sql);//Preparar o Statement
    pstate.setInt(1, idAnimal);
    pstate.setInt(2, idExame);
    pstate.setInt(3, idHistorico);
    pstate.setDate(4, data);
    pstate.setString(5, resultado);
    pstate.setString(6, observacao);
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
   
  //Metodo para receber o id do Historico de exame
  public int idHistoricoExame() throws SQLException, ClassNotFoundException, ExceptionDAO{
    String sql="select max(historico_exame.idHistorico) as id from historico_exame;";
    PreparedStatement pstate=null;
    Connection con=null;
    int idHistorico=0;
try{
con=new ConnectionBD().getConnection();
pstate=con.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);
if(rs!=null){
while(rs.next()){
idHistorico=rs.getInt("id");}
}
else{JOptionPane.showMessageDialog(null, "Não foi encontrado idHistorico");}

    
}
catch(SQLException ex){ throw new ExceptionDAO("Erro ao buscar o id do historico: "+ex); }
finally{ConnectionBD cm = new ConnectionBD();
  cm.fecharConexao(pstate, con);}
      
  return idHistorico;  
    }
     
    
}
