/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.DAO;

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
public Vector<Cliente> pesquisarClienteMorada(String morada) throws SQLException, ClassNotFoundException, ExceptionDAO{
Connection cn=null;
PreparedStatement pstate=null;
//String sql="select nome,telefone,morada from cliente where morada = '"+morada+"'";
String sql="select cliente.idCliente,cliente.nome,cliente.telefone,cliente.morada from cliente where cliente.morada= '"+morada+"' group by cliente.idCliente;";

Vector<Cliente> clientes=null;

try{
cn=new ConnectionBD().getConnection();
pstate=cn.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);
if(rs!=null){
String nome,telefone,moradas;
int nrAnimais,id;
clientes = new Vector<>();
while(rs.next()){

nome=rs.getString("nome");
telefone=rs.getString("telefone");
moradas=rs.getString("morada");
//nrAnimais=rs.getInt("numero animais");
id=rs.getInt("idCliente");
Cliente cli= new Cliente(nome, telefone, moradas);
//cli.setNrAnimsais(nrAnimais);
cli.setIdCliente(id);
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
public Vector<Cliente> pesquisarClienteNome(String nome) throws SQLException, ClassNotFoundException, ExceptionDAO{
Connection cn=null;
PreparedStatement pstate=null;
String sql="select cliente.idCliente,cliente.nome,cliente.telefone,cliente.morada from cliente where cliente.nome like  '%"+nome+"%';";

Vector<Cliente> clientes=null;

try{
cn=new ConnectionBD().getConnection();
pstate=cn.prepareStatement(sql);
ResultSet rs= pstate.executeQuery(sql);
if(rs!=null){
String name,telefone,moradas;
int nrAnimais,id;
clientes = new Vector<>();
while(rs.next()){

name=rs.getString("nome");
telefone=rs.getString("telefone");
moradas=rs.getString("morada");
id=rs.getInt("idCliente");
//nrAnimais=rs.getInt("numero animais");
Cliente cli= new Cliente(name, telefone, moradas);
//cli.setNrAnimsais(nrAnimais);
cli.setIdCliente(id);
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

public void actualizarCliente(Cliente cliente) throws SQLException, ClassNotFoundException, ExceptionDAO{
    String nome,telefone,morada;
    int id;
    nome=cliente.getNome();
    telefone=cliente.getTelefone();
    morada=cliente.getMorada();
    id=cliente.getIdCliente();
    
    String sql="update cliente set nome= ?,telefone= ?,morada= ? where idCliente=?";
    PreparedStatement pstate=null;
    Connection con=null;
        
    try{
    con=new ConnectionBD().getConnection();//Criar conexao
    pstate=con.prepareStatement(sql);//Preparar o Statement
    pstate.setString(1, nome);
    pstate.setString(2, telefone);
    pstate.setString(3, morada);
    pstate.setInt(4, id);//idcliente
    pstate.executeUpdate();
    pstate.close();
    
    }
    catch(SQLException ex){JOptionPane.showMessageDialog(null, "Erro ao actualizar o actor na base de dados"+ex);
       }
    //Fechar prepared Statement e connection
    finally{ ConnectionBD cm= new ConnectionBD();
    cm.fecharConexao(pstate, con);
    }
    }    
public void apagarCliente(Cliente cliente) throws SQLException, ClassNotFoundException, ExceptionDAO{
    int id;
    id=cliente.getIdCliente();
    
    String sql="delete from cliente where idCliente=?";
    PreparedStatement pstate=null;
    Connection con=null;
        
    try{
    con=new ConnectionBD().getConnection();//Criar conexao
    pstate=con.prepareStatement(sql);//Preparar o Statement
    pstate.setInt(1, id);//idcliente
    pstate.executeUpdate();
    pstate.close();
    
    }
    catch(SQLException ex){JOptionPane.showMessageDialog(null, "Erro ao apagar o actor na base de dados"+ex);
       }
    //Fechar prepared Statement e connection
    finally{ ConnectionBD cm= new ConnectionBD();
    cm.fecharConexao(pstate, con);
    }
    } 

 

}

    


