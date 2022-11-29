/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.VO.Animal;
import Model.VO.Vacina;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Valter Boa 53
 */
public class VacinaDAO {
       //Metodo recebe o vacina da model e salva na BD
    public void cadastrarVacina(Vacina vacina) throws SQLException, ClassNotFoundException, ExceptionDAO
    {
    String sql="insert into vacina(marca,nome,especie,quantidade,preco,data_validade,idVeterinaria) values (?,?,?,?,?,?,?);";
    PreparedStatement pstate=null;
    Connection con=null;
    
    String marca = vacina.getMarca();
    String nome= vacina.getNome();
    String especie=vacina.getEspecie();
    Float quantidade = vacina.getQuantidade();
    Float preco = vacina.getPreco();
    Date data = vacina.getData();
  
    try{
    con=new ConnectionBD().getConnection();//Criar conexao
    pstate=con.prepareStatement(sql);//Preparar o Statement
    pstate.setString(1, marca);
    pstate.setString(2, nome);
    pstate.setString(3, especie);
    pstate.setFloat(4, quantidade);
    pstate.setFloat(5, preco);
    pstate.setDate(6, data);
    pstate.setInt(7, 1);
    pstate.executeUpdate();
    pstate.close();
 
    }
    catch(SQLException ex){JOptionPane.showMessageDialog(null, "Erro ao gravar a vacina na base de dados"+ex);
       }
    
    }

 public Vector<Vacina> pesquisarVacinaMarca(String mark) throws ClassNotFoundException, ExceptionDAO {
Connection cn=null;
PreparedStatement pstate=null;
String sql="select vacina.nome,vacina.preco,vacina.data_validade,vacina.quantidade from vacina where vacina.marca like'%"+mark+"%';";

Vector<Vacina> vacinas=null;

try{
cn=new ConnectionBD().getConnection();
pstate=cn.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);
if(rs!=null){

String nome;
float preco,quantidade;
Date data;
vacinas = new Vector<>();
while(rs.next()){

nome=rs.getString("nome");
preco=rs.getFloat("preco");
data=rs.getDate("data_validade");
quantidade=rs.getFloat("quantidade");
Vacina vacina= new Vacina();
vacina.setNome(nome);
vacina.setPreco(preco);
vacina.setData(data);
vacina.setQuantidade(quantidade);
vacinas.add(vacina);

}

}
else{JOptionPane.showMessageDialog(null, "A vacina Nao foi encontrado");}

}

catch(SQLException ex){ throw new ExceptionDAO("Erro ao buscar a vacina: "+ex); }
finally{ConnectionBD cm = new ConnectionBD();
  cm.fecharConexao(pstate, cn);}
      
  return  vacinas;  
}  

 
 public Vector<Vacina> pesquisarVacinaNome(String name) throws ClassNotFoundException, ExceptionDAO {
Connection cn=null;
PreparedStatement pstate=null;
String sql="select vacina.nome,vacina.preco,vacina.data_validade,vacina.quantidade from vacina where vacina.nome like'%"+name+"%';";

Vector<Vacina> vacinas=null;

try{
cn=new ConnectionBD().getConnection();
pstate=cn.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);
if(rs!=null){

String nome;
float preco,quantidade;
Date data;
vacinas = new Vector<>();
while(rs.next()){

nome=rs.getString("nome");
preco=rs.getFloat("preco");
data=rs.getDate("data_validade");
quantidade=rs.getFloat("quantidade");
Vacina vacina= new Vacina();
vacina.setNome(nome);
vacina.setPreco(preco);
vacina.setData(data);
vacina.setQuantidade(quantidade);
vacinas.add(vacina);

}

}
else{JOptionPane.showMessageDialog(null, "A vacina "+name+" Nao foi encontrado");}

}

catch(SQLException ex){ throw new ExceptionDAO("Erro ao buscar a vacina pelo nome: "+ex); }
finally{ConnectionBD cm = new ConnectionBD();
  cm.fecharConexao(pstate, cn);}
      
  return  vacinas;  
}  



}