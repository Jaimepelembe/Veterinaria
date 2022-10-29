/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author multi
 */
import Model.Animal;
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
    String sql="insert into animal(nome,especie,sexo,raca,cor_pelo,peso,dt_nascimento,idCliente,idVeterinaria) values (?,?,?,?,?,?,?,?,?)";
    PreparedStatement pstate=null;
    Connection con=null;
    String nome=animal.getNome();
    String especie=animal.getEspecie();
    String sexo=""+animal.getSexo();
    String raca= animal.getRaca();
    String pelo=animal.getCor_pelo();
    float peso=animal.getPeso();
   String  data=animal.getDt_nascimento();
   
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
    pstate.setString(7, data);
    pstate.setInt(8, idCli);
    pstate.setInt(9, idVet);
    }
    catch(SQLException ex){JOptionPane.showMessageDialog(null, "Erro ao gravar o actor na base de dados"+ex);
       }
    //Fechar prepared Statement e connection
    finally{ ConnectionBD cm= new ConnectionBD();
    cm.fecharConexao(pstate, con);
    }
    }
}
