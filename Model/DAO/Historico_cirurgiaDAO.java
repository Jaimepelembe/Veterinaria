/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.VO.Cirurgia;
import Model.VO.Exame;
import Model.VO.Historico_Cirurgia;
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
public class Historico_CirurgiaDAO {
    
    
public void cadastrarHistorico(Historico_Cirurgia historico) throws SQLException, ClassNotFoundException, ExceptionDAO{
    String sql="call  veterinaria.proc_CastrarAnimal(?, ?, ?, ?, ?);";
    PreparedStatement pstate=null;
    Connection con=null;
   int idAnimal= historico.getIdAnimal();
   int idCirurgia=historico.getIdCirurgia();
    Date data= historico.getData();
   float preco=historico.getPreco();
   String observacao=historico.getObservacao();
        
    try{
    con=new ConnectionBD().getConnection();//Criar conexao
    pstate=con.prepareStatement(sql);//Preparar o Statement
    pstate.setInt(1, idAnimal);
    pstate.setInt(2, idCirurgia);
    pstate.setDate(3, data);
    pstate.setFloat(4, preco);
    pstate.setString(5, observacao);
    pstate.executeUpdate();
    pstate.close();
 
    }
    catch(SQLException ex){JOptionPane.showMessageDialog(null, "Erro ao gravar o historico da cirurgia na base de dados"+ex);
       }
    //Fechar prepared Statement e connection
    finally{ ConnectionBD cm= new ConnectionBD();
    cm.fecharConexao(pstate, con);
    }
    }
 
public Vector<Cirurgia> selecionarCirurgias() throws SQLException, ClassNotFoundException, ExceptionDAO{
Connection cn=null;
PreparedStatement pstate=null;
String sql="select cirurgia.nome,cirurgia.idCirurgia from cirurgia;";

Vector<Cirurgia> cirurgias=null;

try{
cn=new ConnectionBD().getConnection();
pstate=cn.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);

if(rs!=null){
String nome;
int idCirurgia;
cirurgias = new Vector<>();
while(rs.next()){
idCirurgia=rs.getInt("idCirurgia");
nome=rs.getString("nome");

Cirurgia cirurgia = new Cirurgia();
cirurgia.setIdCirurgia(idCirurgia);
cirurgia.setNome(nome);
cirurgias.add(cirurgia);

}
}
else{JOptionPane.showMessageDialog(null, "Nao foi encontrado nenhuma cirurgia");}


    
}
catch(SQLException ex){ throw new ExceptionDAO("Erro ao buscar a cirurgias: "+ex); }
finally{ConnectionBD cm = new ConnectionBD();
  cm.fecharConexao(pstate, cn);}
      
  return cirurgias;  
} 

    
    
}
