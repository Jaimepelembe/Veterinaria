/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Controller.Historico_ExameController;
import Model.VO.Animal;
import Model.VO.Cliente;
import Model.VO.Exame;
import Model.VO.Historico_vacina;
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
 * @author multi
 */
public class Historico_VacinaDAO {


public Vector<Animal> selecionarAnimais() throws SQLException, ClassNotFoundException, ExceptionDAO{
Connection cn=null;
PreparedStatement pstate=null;
String sql="select animal.idAnimal,animal.nome from animal;";

Vector<Animal> animais=null;

try{
cn=new ConnectionBD().getConnection();
pstate=cn.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);
if(rs!=null){
int  idAnimal;
String nome;
animais = new Vector<>();
while(rs.next()){
idAnimal=rs.getInt("idAnimal");
nome=rs.getString("nome");
Animal animal= new Animal();
animal.setIdAnimal(idAnimal);
animal.setNome(nome);
animais.add(animal);

}
}
else{JOptionPane.showMessageDialog(null, "Nao foi encontrado nenhum animal");}


    
}
catch(SQLException ex){ throw new ExceptionDAO("Erro ao buscar o animal: "+ex); }
finally{ConnectionBD cm = new ConnectionBD();
  cm.fecharConexao(pstate, cn);}
      
  return animais;  
} 

public Vector<Animal> selecionarAnimaisEspecie(String specie) throws SQLException, ClassNotFoundException, ExceptionDAO{
Connection cn=null;
PreparedStatement pstate=null;
String sql="select animal.idAnimal,animal.nome from animal where especie='"+specie+"';";

Vector<Animal> animais=null;

try{
cn=new ConnectionBD().getConnection();
pstate=cn.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);
if(rs!=null){
int  idAnimal;
String nome;
animais = new Vector<>();
while(rs.next()){
idAnimal=rs.getInt("idAnimal");
nome=rs.getString("nome");
Animal animal= new Animal();
animal.setIdAnimal(idAnimal);
animal.setNome(nome);
animais.add(animal);

}
}
else{JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum animal");}


    
}
catch(SQLException ex){ throw new ExceptionDAO("Erro ao buscar o animal: "+ex); }
finally{ConnectionBD cm = new ConnectionBD();
  cm.fecharConexao(pstate, cn);}
      
  return animais;  
} 

public Vector<Vacina> selecionarVacinas(String Especie) throws SQLException, ClassNotFoundException, ExceptionDAO{
Connection cn=null;
PreparedStatement pstate=null;
String sql="select vacina.nome,vacina.preco,vacina.idVacina from vacina where especie='"+Especie+"';";

Vector<Vacina> vacinas=null;

try{
cn=new ConnectionBD().getConnection();
pstate=cn.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);
if(rs!=null){
float preco;
String nome;
int idVacina;
vacinas = new Vector<>();
while(rs.next()){
idVacina=rs.getInt("idVacina");
nome=rs.getString("nome");
preco=rs.getFloat("preco");

Vacina vacina= new Vacina();
vacina.setIdVacina(idVacina);
vacina.setNome(nome);
vacina.setPreco(preco);
vacinas.add(vacina);

}
}
else{JOptionPane.showMessageDialog(null, "Nao foi encontrado nenhuma vacina");}


    
}
catch(SQLException ex){ throw new ExceptionDAO("Erro ao buscar a vacina: "+ex); }
finally{ConnectionBD cm = new ConnectionBD();
  cm.fecharConexao(pstate, cn);}
      
  return vacinas;  
} 

  public void cadastrarExame(Historico_vacina historico) throws SQLException, ClassNotFoundException, ExceptionDAO{
    String sql="insert into historico_vacina (idAnimal,idVacina,preco,data_realizacao,observacao) values (?,?,?,?,?);";
    PreparedStatement pstate=null;
    Connection con=null;
    int idAnimal= historico.getIdAnimal();
    int idVacina= historico.getIdVacina();
    float preco=historico.getPreco();
    Date data=historico.getData();
    String observacao=historico.getObservacao();
    
    try{
    con=new ConnectionBD().getConnection();//Criar conexao
    pstate=con.prepareStatement(sql);//Preparar o Statement
    pstate.setInt(1, idAnimal);
    pstate.setInt(2, idVacina);
    pstate.setFloat(3, preco);
    pstate.setDate(4, data);
    pstate.setString(5,observacao);
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
