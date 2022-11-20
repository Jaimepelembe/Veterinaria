/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

import Model.VO.Animal;
import Model.VO.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author multi
 */
public class ExameDAO {


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

public Vector<Animal> selecionarExamesEspecie() throws SQLException, ClassNotFoundException, ExceptionDAO{
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


}
