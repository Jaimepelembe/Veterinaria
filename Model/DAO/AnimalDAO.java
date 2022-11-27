/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

/**
 *
 * @author multi
 */
import Model.VO.Animal;
import Model.VO.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.time.LocalDate;
public class AnimalDAO {
 
    //Metodo recebe o animal da model e salva na BD
    public void cadastrarAnimal(Animal animal) throws SQLException, ClassNotFoundException, ExceptionDAO{
    String sql="insert into animal(nome,especie,sexo,raca,cor_pelo,peso,dt_nascimento,idCliente,idVeterinaria) values (?,?,?,?,?,?,?,?,?);";
    PreparedStatement pstate=null;
    Connection con=null;
    String nome=animal.getNome();
    String especie=animal.getEspecie();
    String sexo=""+animal.getSexo();
    String raca= animal.getRaca();
    String pelo=animal.getCor_pelo();
    float peso=animal.getPeso();
   Date  data= animal.getDt_nascimento() ;
    int idCli=animal.getIdCliente();
    int idVet=animal.getIdVeterinaria();
        
    try{
    con=new ConnectionBD().getConnection();//Criar conexao
    pstate=con.prepareStatement(sql);//Preparar o Statement
    pstate.setString(1, nome);
    pstate.setString(2, especie);
    pstate.setString(3, sexo);
    pstate.setString(4, raca);
    pstate.setString(5, pelo);
    pstate.setFloat(6, peso);
    pstate.setDate(7, data);
    pstate.setInt(8, idCli);
    pstate.setInt(9, idVet);
    pstate.executeUpdate();
    pstate.close();
 
    }
    catch(SQLException ex){JOptionPane.showMessageDialog(null, "Erro ao gravar o animal na base de dados"+ex);
       }
    //Fechar prepared Statement e connection
    finally{ ConnectionBD cm= new ConnectionBD();
    cm.fecharConexao(pstate, con);
    }
    }
    
public void actualizarAnimal(Animal animal) throws SQLException, ClassNotFoundException, ExceptionDAO{
    String nome,especie,sexo,raca,cor;
    Date data;
    int id;
    float peso;
    id=animal.getIdAnimal();
    nome=animal.getNome();
    especie=animal.getEspecie();
    sexo=animal.getSexo();
    raca=animal.getRaca();
    cor=animal.getCor_pelo();
    peso=animal.getPeso();
    data=animal.getDt_nascimento();
   
    
    String sql="update animal set nome= ?,especie= ?,sexo= ?, raca=?,cor_pelo=?,peso=?,dt_nascimento=? where idAnimal=?";
    PreparedStatement pstate=null;
    Connection con=null;
        
    try{
    con=new ConnectionBD().getConnection();//Criar conexao
    pstate=con.prepareStatement(sql);//Preparar o Statement
    pstate.setString(1, nome);
    pstate.setString(2, especie);
    pstate.setString(3, sexo);
    pstate.setString(4, raca);
    pstate.setString(5, cor);
    pstate.setFloat(6, peso);
    pstate.setDate(7, data);
    pstate.setInt(8, id);
    pstate.executeUpdate();
    pstate.close();
    
    }
    catch(SQLException ex){JOptionPane.showMessageDialog(null, "Erro ao actualizar o animal na base de dados"+ex);
       }
    //Fechar prepared Statement e connection
    finally{ ConnectionBD cm= new ConnectionBD();
    cm.fecharConexao(pstate, con);
    }
    }    
public void apagarAnimal(Animal animal) throws SQLException, ClassNotFoundException, ExceptionDAO{
    int id;
    id=animal.getIdAnimal();
    
    String sql="delete from animal where idAnimal=?";
    PreparedStatement pstate=null;
    Connection con=null;
        
    try{
    con=new ConnectionBD().getConnection();//Criar conexao
    pstate=con.prepareStatement(sql);//Preparar o Statement
    pstate.setInt(1, id);//idAnimal
    pstate.executeUpdate();
    pstate.close();
    
    }
    catch(SQLException ex){JOptionPane.showMessageDialog(null, "Erro ao apagar o Animal da base de dados"+ex);
       }
    //Fechar prepared Statement e connection
    finally{ ConnectionBD cm= new ConnectionBD();
    cm.fecharConexao(pstate, con);
    }
    }

public Vector<Cliente> selecionarCliente() throws SQLException, ClassNotFoundException, ExceptionDAO{
Connection cn=null;
PreparedStatement pstate=null;
String sql="select cliente.idCliente,cliente.idVeterinaria,cliente.nome from cliente;";

Vector<Cliente> clientes=null;

try{
cn=new ConnectionBD().getConnection();
pstate=cn.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);
if(rs!=null){
int  idCliente,idVeterinaria;
String nome;
clientes = new Vector<>();
while(rs.next()){

idCliente=rs.getInt("idCliente");
idVeterinaria=rs.getInt("idVeterinaria");
nome=rs.getString("nome");
Cliente cli= new Cliente();
cli.setIdCliente(idCliente);
cli.setIdVeterinaria(idVeterinaria);
cli.setNome(nome);
clientes.add(cli);
}

}
else{JOptionPane.showMessageDialog(null, "O cliente Nao foi encontrado");}

}

catch(SQLException ex){ throw new ExceptionDAO("Erro ao buscar o cliente: "+ex); }
finally{ConnectionBD cm = new ConnectionBD();
  cm.fecharConexao(pstate, cn);}
      
  return clientes;  
} 

public Vector<Animal> pesquisarAnimalEspecie(String especie) throws ClassNotFoundException, ExceptionDAO {
Connection cn=null;
PreparedStatement pstate=null;
String sql="select animal.idAnimal,animal.nome,animal.especie,animal.sexo,animal.raca,animal.cor_pelo,animal.peso,animal.dt_nascimento from animal where animal.especie='"+especie+"';";

Vector<Animal> animais=null;

try{
cn=new ConnectionBD().getConnection();
pstate=cn.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);
if(rs!=null){
int  idAnimal;
float peso;
String nome,esp,sexo,raca,pelo;
Date data;
animais = new Vector<>();
while(rs.next()){

idAnimal=rs.getInt("idAnimal");
nome=rs.getString("nome");
esp=rs.getString("especie");
sexo=rs.getString("sexo");
raca=rs.getString("raca");
pelo= rs.getString("cor_pelo");
peso=rs.getFloat("peso");
data=rs.getDate("dt_nascimento");
Animal animal= new Animal();
animal.setIdAnimal(idAnimal);
animal.setNome(nome);
animal.setEspecie(especie);
animal.setSexo(sexo);
animal.setRaca(raca);
animal.setCor_pelo(pelo);
animal.setPeso(peso);
animal.setDt_nascimento(data);

animais.add(animal);

}

}
else{JOptionPane.showMessageDialog(null, "O animal Nao foi encontrado");}

}

catch(SQLException ex){ throw new ExceptionDAO("Erro ao buscar o animal: "+ex); }
finally{ConnectionBD cm = new ConnectionBD();
  cm.fecharConexao(pstate, cn);}
      
  return  animais;  
}  


public Vector<Animal> pesquisarAnimalRaca(String rac) throws ClassNotFoundException, ExceptionDAO {
Connection cn=null;
PreparedStatement pstate=null;
String sql="select animal.idAnimal,animal.nome,animal.especie,animal.sexo,animal.raca,animal.cor_pelo,animal.peso,animal.dt_nascimento from animal where animal.raca='"+rac+"';";

Vector<Animal> animais=null;

try{
cn=new ConnectionBD().getConnection();
pstate=cn.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);
if(rs!=null){
int  idAnimal;
float peso;
String nome,esp,sexo,raca,pelo;
Date data;

animais = new Vector<>();
while(rs.next()){

idAnimal=rs.getInt("idAnimal");
nome=rs.getString("nome");
esp=rs.getString("especie");
sexo=rs.getString("sexo");
raca=rs.getString("raca");
pelo= rs.getString("cor_pelo");
peso=rs.getFloat("peso");
data=rs.getDate("dt_nascimento");
Animal animal= new Animal();
animal.setIdAnimal(idAnimal);
animal.setNome(nome);
animal.setEspecie(esp);
animal.setSexo(sexo);
animal.setRaca(raca);
animal.setCor_pelo(pelo);
animal.setPeso(peso);
animal.setDt_nascimento(data);

animais.add(animal);

}

}
else{JOptionPane.showMessageDialog(null, "O animal Nao foi encontrado");}

}

catch(SQLException ex){ throw new ExceptionDAO("Erro ao buscar o animal: "+ex); }
finally{ConnectionBD cm = new ConnectionBD();
  cm.fecharConexao(pstate, cn);}
      
  return  animais;  
}  


public Vector<Animal> pesquisarAnimalNome(String name) throws ClassNotFoundException, ExceptionDAO {
Connection cn=null;
PreparedStatement pstate=null;
String sql="select animal.idAnimal,animal.nome,animal.especie,animal.sexo,animal.raca,animal.cor_pelo,animal.peso,animal.dt_nascimento from animal where animal.nome like  '%"+name+"%';";

Vector<Animal> animais=null;

try{
cn=new ConnectionBD().getConnection();
pstate=cn.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);
if(rs!=null){
int  idAnimal;
float peso;
String nome,esp,sexo,raca,pelo;
Date data;
animais = new Vector<>();
while(rs.next()){

idAnimal=rs.getInt("idAnimal");
nome=rs.getString("nome");
esp=rs.getString("especie");
sexo=rs.getString("sexo");
raca=rs.getString("raca");
pelo= rs.getString("cor_pelo");
peso=rs.getFloat("peso");
data=rs.getDate("dt_nascimento");
Animal animal= new Animal();
animal.setIdAnimal(idAnimal);
animal.setNome(nome);
animal.setEspecie(esp);
animal.setSexo(sexo);
animal.setRaca(raca);
animal.setCor_pelo(pelo);
animal.setPeso(peso);
animal.setDt_nascimento(data);

animais.add(animal);

}

}
else{JOptionPane.showMessageDialog(null, "O animal Nao foi encontrado");}

}

catch(SQLException ex){ throw new ExceptionDAO("Erro ao buscar o animal: "+ex); }
finally{ConnectionBD cm = new ConnectionBD();
  cm.fecharConexao(pstate, cn);}
      
  return  animais;  
}  


        }
